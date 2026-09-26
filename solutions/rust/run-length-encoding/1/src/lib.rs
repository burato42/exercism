pub fn encode(source: &str) -> String {
    let mut prev_letter: Option<char> = None;
    let mut counter = 0;
    let mut result = Vec::<(usize, char)>::new();
    for letter in source.chars() {
        match prev_letter {
            Some(p) if p == letter => counter += 1,
            Some(p) => {
                result.push((counter, p));
                prev_letter = Some(letter);
                counter = 1;
            }
            None => {
                prev_letter = Some(letter);
                counter = 1;
            }
        }
    }
    if let Some(c) = prev_letter {
        result.push((counter, c));
    }
    result
        .iter()
        .map(|(cnt, letter)| {
            if *cnt == 1 {
                letter.to_string()
            } else {
                cnt.to_string() + &letter.to_string()
            }
        })
        .collect()
}

pub fn decode(source: &str) -> String {
    let mut result = Vec::<(usize, char)>::new();
    let mut cnt_cand = Vec::<char>::new();
    for symbol in source.chars() {
        if symbol.is_ascii_digit() {
            cnt_cand.push(symbol);
        } else if cnt_cand.is_empty() {
            result.push((1, symbol));
        } else {
            result.push((
                cnt_cand
                    .iter()
                    .collect::<String>()
                    .parse::<usize>()
                    .unwrap(),
                symbol,
            ));
            cnt_cand.clear();
        }
    }
    result
        .iter()
        .map(|(cnt, letter)| letter.to_string().repeat(*cnt))
        .collect()
}
