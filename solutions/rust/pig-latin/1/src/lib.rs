fn pig_latinize(word: &str) -> String {
    if "aeiou".contains(word.chars().nth(0).unwrap()) || (word.len() >= 2 && (vec!["xr", "yt"].contains(&&word[0..2]))) {
        word.to_owned() + "ay"
    } else if word.contains("qu") && word[0..word.find("qu").unwrap()].chars().all(|x| !"aeiou".contains(x)) {
        let qu_idx = word.find("qu").unwrap();
        let first = &word[0..qu_idx + 2];
        let second = &word[qu_idx + 2..];
        format!("{}{}ay", second, first)
    } else if word.contains("y") && word.chars().nth(0).unwrap() != 'y' && word[0..word.find("y").unwrap()].chars().all(|x| !"aeiou".contains(x)) {
        let y_idx = word.find("y").unwrap();
        let first = &word[0..y_idx];
        let second = &word[y_idx + 1..];
        format!("y{}{}ay", second, first)
    } else if !word.chars().take_while(|x| !"aeiou".contains(*x)).collect::<String>().is_empty() {
        let first = word.chars().take_while(|x| !"aeiou".contains(*x)).collect::<String>();
        let second = &word[first.len()..];
        format!("{}{}ay", second, first)
    }
    else {
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
