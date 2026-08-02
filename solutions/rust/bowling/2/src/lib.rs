const PINS_PER_FRAME: u16 = 10;
const FRAMES_PER_GAME: usize = 10;
const LAST_FRAME: usize = FRAMES_PER_GAME - 1;

#[derive(Debug, PartialEq, Eq)]
pub enum Error {
    NotEnoughPinsLeft,
    GameComplete,
}

/// Scores a game without recording every roll: the only history kept is how
/// many of the next rolls still count twice, tracked as one bonus per pending
/// strike/spare.
#[derive(Default)]
pub struct BowlingGame {
    frame: usize,
    score: u16,
    /// Pins still standing in the current frame.
    pins_left: u16,
    /// Whether the current frame has already had its first roll.
    second_roll: bool,
    /// Countdown of upcoming rolls that a previous strike/spare doubles. At
    /// most two entries can be live at once (two strikes in a row).
    bonus_rolls: [u8; 2],
    /// Rolls taken so far in the tenth frame.
    final_frame_rolls: u8,
    /// Whether the tenth frame's strike or spare unlocked a third roll.
    earned_fill_ball: bool,
    started: bool,
    finished: bool,
}

impl BowlingGame {
    pub fn new() -> Self {
        Self {
            pins_left: PINS_PER_FRAME,
            ..Default::default()
        }
    }

    pub fn roll(&mut self, pins: u16) -> Result<(), Error> {
        if self.finished {
            return Err(Error::GameComplete);
        }
        if pins > self.pins_left {
            return Err(Error::NotEnoughPinsLeft);
        }

        self.started = true;
        self.score += pins * (1 + self.claim_bonuses());

        if self.frame == LAST_FRAME {
            self.roll_final_frame(pins);
        } else {
            self.roll_normal_frame(pins);
        }

        Ok(())
    }

    pub fn score(&self) -> Option<u16> {
        (self.started && self.finished).then_some(self.score)
    }

    /// Consumes one bonus from each pending strike/spare and reports how many
    /// applied, i.e. how many extra times this roll counts.
    fn claim_bonuses(&mut self) -> u16 {
        let mut multiplier = 0;
        for remaining in self.bonus_rolls.iter_mut() {
            if *remaining > 0 {
                *remaining -= 1;
                multiplier += 1;
            }
        }
        multiplier
    }

    /// Registers a strike (next two rolls doubled) or a spare (next one).
    fn award_bonus(&mut self, rolls: u8) {
        let slot = if self.bonus_rolls[0] == 0 { 0 } else { 1 };
        self.bonus_rolls[slot] = rolls;
    }

    fn roll_normal_frame(&mut self, pins: u16) {
        self.pins_left -= pins;

        let strike = !self.second_roll && self.pins_left == 0;
        let spare = self.second_roll && self.pins_left == 0;

        if strike {
            self.award_bonus(2);
        } else if spare {
            self.award_bonus(1);
        }

        if strike || self.second_roll {
            self.start_next_frame();
        } else {
            self.second_roll = true;
        }
    }

    fn start_next_frame(&mut self) {
        self.frame += 1;
        self.second_roll = false;
        self.pins_left = PINS_PER_FRAME;
    }

    /// The tenth frame gets two rolls, plus a fill ball if those two clear the
    /// rack. Fill balls score at face value and award no bonus — they *are*
    /// the bonus for the strike or spare that earned them.
    fn roll_final_frame(&mut self, pins: u16) {
        self.pins_left -= pins;
        self.final_frame_rolls += 1;

        // Clearing the rack re-racks it so the next roll has ten pins again.
        let cleared = self.pins_left == 0;
        if cleared {
            self.pins_left = PINS_PER_FRAME;
        }

        // Earned a third roll by striking on the first, or clearing across the
        // first two rolls (double strike or spare).
        self.earned_fill_ball |= cleared;

        let allowed_rolls = if self.earned_fill_ball { 3 } else { 2 };
        if self.final_frame_rolls == allowed_rolls {
            self.finished = true;
        }
    }
}
