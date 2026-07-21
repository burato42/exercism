use std::collections::HashSet;


fn sorted_lower(s: &str) -> Vec<char> {
    let mut chars: Vec<char> = s.to_lowercase().chars().collect();
    chars.sort_unstable();
    chars
}

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let word_lower = word.to_lowercase();
    let word_key = sorted_lower(word);

    possible_anagrams
        .iter()
        .filter(|candidate| {
            candidate.to_lowercase() != word_lower && sorted_lower(candidate) == word_key
        })
        .copied()
        .collect()
    
}
