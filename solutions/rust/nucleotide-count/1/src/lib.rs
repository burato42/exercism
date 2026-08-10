use std::collections::HashMap;

const LETTERS: [char; 4] = ['A', 'C', 'G', 'T'];

pub fn count(nucleotide: char, dna: &str) -> Result<usize, char> {
    if !LETTERS.contains(&nucleotide) {
        return Err(nucleotide);
    }

    let mut counter = 0usize;

    for letter in dna.chars() {
        if !LETTERS.contains(&letter) {
            return Err(letter);
        }
        if letter == nucleotide {
            counter += 1;
        }
    }
    Ok(counter)
}

pub fn nucleotide_counts(dna: &str) -> Result<HashMap<char, usize>, char> {
    let mut counter = HashMap::new();
    for letter in LETTERS.iter() {
        counter.insert(*letter, 0);
    }

    for letter in dna.chars() {
        if !LETTERS.contains(&letter) {
            return Err(letter);
        }
        *counter.entry(letter).or_insert(0) += 1;
    }
    Ok(counter)
}
