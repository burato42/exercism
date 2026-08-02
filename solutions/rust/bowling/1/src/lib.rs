#[derive(Debug, PartialEq, Eq)]
pub enum Error {
    NotEnoughPinsLeft,
    GameComplete,
}

pub struct BowlingGame {
    frame: usize,
    points: u16,
    is_started: bool,
    is_finished: bool,
    available_rolls: usize,
    strike_rolls: usize,
    strike_rolls_2: usize,
    spare_rolls: usize,
    pins_left: u16,
    tenth_frame_first_roll_was_strike: bool,
}

/// Attempt to do the calculation without using extra memory
impl BowlingGame {
    pub fn new() -> Self {
        Self {
            frame: 0,
            points: 0,
            is_started: false,
            is_finished: false,
            available_rolls: 2,
            strike_rolls: 0,
            strike_rolls_2: 0,
            spare_rolls: 0,
            pins_left: 10,
            tenth_frame_first_roll_was_strike: false,
        }
    }

    pub fn roll(&mut self, pins: u16) -> Result<(), Error> {
        self.is_started = true;
        if self.is_finished {
            return Err(Error::GameComplete);
        }
        if pins > self.pins_left {
            return Err(Error::NotEnoughPinsLeft);
        }

        if self.frame == 9 {
            self.play_final_frame(pins);
        } else {
            self.play_normal_frame(pins);
        }

        Ok(())
    }

    fn play_normal_frame(&mut self, pins: u16) {
        if self.available_rolls > 0 {
            if pins == 10 && self.available_rolls == 2 {
                self.points += 10;
                if self.strike_rolls > 0 {
                    self.points += 10;
                    self.strike_rolls -= 1;
                }
                if self.strike_rolls_2 > 0 {
                    self.points += 10;
                    self.strike_rolls_2 -= 1;
                }
                if self.spare_rolls > 0 {
                    self.points += pins;
                    self.spare_rolls -= 1;
                }
                if self.strike_rolls == 0 {
                    self.strike_rolls = 2;
                } else {
                    self.strike_rolls_2 = 2;
                }
                self.frame += 1;
            } else {
                self.points += pins;
                self.available_rolls -= 1;
                self.pins_left -= pins;

                if self.strike_rolls > 0 {
                    self.points += pins;
                    self.strike_rolls -= 1;
                }
                if self.strike_rolls_2 > 0 {
                    self.points += pins;
                    self.strike_rolls_2 -= 1;
                }
                if self.spare_rolls > 0 {
                    self.points += pins;
                    self.spare_rolls -= 1;
                }
                if self.pins_left == 0 {
                    self.spare_rolls = 1;
                }
                if self.available_rolls == 0 {
                    self.available_rolls = 2;
                    self.frame += 1;
                    self.pins_left = 10;
                }
            }
        }
        if self.frame == 9 {
            self.available_rolls = 3;
        }
    }

    fn play_final_frame(&mut self, pins: u16) {
            let roll_number = 3 - self.available_rolls;
            let mut was_spare = false;

            if self.strike_rolls > 0 {
                self.points += pins;
                self.strike_rolls -= 1;
            }
            if self.strike_rolls_2 > 0 {
                self.points += pins;
                self.strike_rolls_2 -= 1;
            }
            if self.spare_rolls > 0 {
                self.points += pins;
                self.spare_rolls -= 1;
            }

            if pins == 10 {
                self.points += 10;
                self.pins_left = 10;
                self.available_rolls -= 1;
                if roll_number == 0 {
                    self.tenth_frame_first_roll_was_strike = true;
                }
            } else if self.pins_left == pins {
                self.points += pins;
                self.pins_left = 10;
                self.available_rolls -= 1;
                was_spare = true;
            } else {
                self.points += pins;
                self.pins_left -= pins;
                self.available_rolls -= 1;
            }

            if roll_number == 1 && !self.tenth_frame_first_roll_was_strike && !was_spare {
                self.available_rolls = 0;
            }

            if self.available_rolls == 0 {
                self.is_finished = true;
            }
    }

    pub fn score(&self) -> Option<u16> {
        if !self.is_started {
            None
        } else if self.is_finished {
            Some(self.points)
        } else {
            None
        }
    }
}
