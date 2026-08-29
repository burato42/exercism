const VOWELS: &str = "aeiou";
const SUFFIX: &str = "ay";
const VOWEL_SOUNDS: &[&str] = &["xr", "yt"];

fn comply_rule_1(word: &str) -> bool {
    VOWELS.contains(word.chars().nth(0).unwrap())
        || (word.len() >= 2 && (VOWEL_SOUNDS.contains(&&word[0..2])))
}

fn comply_rule_2(word: &str) -> bool {
    !word
        .chars()
        .take_while(|x| !"aeiou".contains(*x))
        .collect::<String>()
        .is_empty()
}

fn comply_rule_3(word: &str) -> bool {
    word.contains("qu")
        && word[0..word.find("qu").unwrap()]
            .chars()
            .all(|x| !VOWELS.contains(x))
}

fn comply_rule_4(word: &str) -> bool {
    word.contains("y")
        && word.chars().nth(0).unwrap() != 'y'
        && word[0..word.find("y").unwrap()]
            .chars()
            .all(|x| !"aeiou".contains(x))
}

fn pig_latinize(word: &str) -> String {
    if comply_rule_1(word) {
        format!("{}{}", word, SUFFIX)
    } else if comply_rule_3(word) {
        let qu_idx = word.find("qu").unwrap();
        let first = &word[0..qu_idx + 2];
        let second = &word[qu_idx + 2..];
        format!("{}{}ay", second, first)
    } else if comply_rule_4(word) {
        let y_idx = word.find("y").unwrap();
        let first = &word[0..y_idx];
        let second = &word[y_idx + 1..];
        format!("y{}{}ay", second, first)
    } else if comply_rule_2(word) {
        let first = word
            .chars()
            .take_while(|x| !VOWELS.contains(*x))
            .collect::<String>();
        let second = &word[first.len()..];
        format!("{}{}ay", second, first)
    } else {
        word.to_owned()
    }
}

pub fn translate(input: &str) -> String {
    input
        .split(" ")
        .map(pig_latinize)
        .collect::<Vec<String>>()
        .join(" ")
}
