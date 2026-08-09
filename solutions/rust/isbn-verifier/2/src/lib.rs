/// Determines whether the supplied string is a valid ISBN number
pub fn is_valid_isbn(isbn: &str) -> bool {
    let mut sum = 0;
    let mut position = 0;

    for c in isbn.chars().filter(|c| *c != '-') {
        let digit = match c {
            'X' if position == 9 => 10,
            _ => match c.to_digit(10) {
                Some(d) => d,
                None => return false,
            },
        };

        if position == 10 {
            return false;
        }
        sum += digit * (10 - position);
        position += 1;
    }

    position == 10 && sum % 11 == 0
}
