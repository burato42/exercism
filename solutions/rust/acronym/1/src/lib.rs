pub fn abbreviate(phrase: &str) -> String {
    phrase
        .split([' ', '-'])
        .map(|word| {
            let chars: Vec<char> = word.chars().filter(|c| c.is_alphabetic()).collect();
            chars
                .iter()
                .enumerate()
                .filter(|(pos, x)| *pos == 0 || (x.is_uppercase() && chars[pos - 1].is_lowercase()))
                .map(|(_, x)| x.to_uppercase().to_string())
                .collect::<String>()
        })
        .collect()
}
