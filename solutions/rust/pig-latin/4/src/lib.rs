const VOWELS: &str = "aeiou";
const SUFFIX: &str = "ay";
const VOWEL_SOUNDS: &[&str] = &["xr", "yt"];

fn split_index(word: &str) -> usize {
    if word.starts_with(|c| VOWELS.contains(c))
        || VOWEL_SOUNDS.iter().any(|s| word.starts_with(s))
    {
        return 0;
    }
    word.char_indices()
        .skip(1) // a leading 'y' is a consonant; after that it acts as a vowel
        .find_map(|(i, c)| match c {
            'u' if word[..i].ends_with('q') => None, // "qu" moves as a unit
            c if VOWELS.contains(c) || c == 'y' => Some(i),
            _ => None,
        })
        .unwrap_or(word.len())
}

fn pig_latinize(word: &str) -> String {
    let i = split_index(word);
    format!("{}{}{}", &word[i..], &word[..i], SUFFIX)
}

pub fn translate(input: &str) -> String {
    input
        .split(" ")
        .map(pig_latinize)
        .collect::<Vec<String>>()
        .join(" ")
}
