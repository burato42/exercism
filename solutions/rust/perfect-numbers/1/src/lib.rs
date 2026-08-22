#[derive(Debug, PartialEq, Eq)]
pub enum Classification {
    Abundant,
    Perfect,
    Deficient,
}

pub fn classify(num: u64) -> Option<Classification> {
    if num == 0 {
        return None;
    }
    let aliquot_sum: u64 = (1..num).filter(|x| num.is_multiple_of(*x)).sum();
    match aliquot_sum {
        x if x == num => Some(Classification::Perfect),
        x if x > num => Some(Classification::Abundant),
        x if x < num => Some(Classification::Deficient),
        _ => None,
    }
}
