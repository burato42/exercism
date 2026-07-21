use std::fmt::Display;

const HOURS_PER_DAY: i32 = 24;
const MINUTES_PER_HOUR: i32 = 60;

#[derive(PartialEq, Debug)]
pub struct Clock {
    total_minutes: i32
}


impl Display for Clock {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:02}:{:02}", &self.get_hours(), &self.get_minutes())
    }
}


impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let overall_minutes = hours * MINUTES_PER_HOUR + minutes;

        Self {total_minutes: overall_minutes.rem_euclid(HOURS_PER_DAY * MINUTES_PER_HOUR) }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Self::new(0, self.total_minutes + minutes)
    }

    fn get_hours(&self) -> i32 {
        self.total_minutes / MINUTES_PER_HOUR
    }

    fn get_minutes(&self) -> i32 {
        self.total_minutes % MINUTES_PER_HOUR
    }
}
