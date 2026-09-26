pub fn encode(source: &str) -> String {
    let mut result = String::new();
    let mut chars = source.chars().peekable();
    while let Some(letter) = chars.next() {
        let mut counter = 1;
        while chars.next_if_eq(&letter).is_some() {
            counter += 1;
        }
        push_run(&mut result, counter, letter);
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
