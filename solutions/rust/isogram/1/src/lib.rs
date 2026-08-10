use std::collections::HashSet;

pub fn check(candidate: &str) -> bool {
    let cleaned = candidate
        .chars()
        .map(|x| x.to_ascii_lowercase())
        .filter(|x| x.is_alphabetic());
    cleaned.clone().collect::<HashSet<char>>().len() == cleaned.collect::<String>().len()
}
