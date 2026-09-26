pub fn encode(source: &str) -> String {
    let mut prev_letter: Option<char> = None;
    let mut counter = 0;
    let mut result = String::from("");
    for letter in source.chars() {
        if prev_letter == Some(letter) {
            counter += 1;
            continue;
        }
        if let Some(p) = prev_letter {
            push_run(&mut result, counter, p);
        }
        prev_letter = Some(letter);
        counter = 1;
    }
    if let Some(p) = prev_letter {
        push_run(&mut result, counter, p);
    }
    result
}

fn push_run(out: &mut String, count: usize, c: char) {
    if count > 1 {
        out.push_str(&count.to_string());
    }
    out.push(c);
}

pub fn decode(source: &str) -> String {
    let mut result = String::new();
    let mut count = 0;
    for symbol in source.chars() {
        if let Some(d) = symbol.to_digit(10) {
            count = count * 10 + d as usize;
        } else {
            result.extend(std::iter::repeat_n(symbol, count.max(1)));
            count = 0;
        }
    }
    result
}
