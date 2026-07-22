/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {
    let no_space: Vec<char> = code.chars().filter(|x| *x != ' ').collect();

    let only_digits: Vec<_> = no_space.iter().filter(|x| x.is_digit(10)).collect();

    if no_space.len() != only_digits.len() {
        return false;
    }

    let lunh_seq = only_digits
        .iter()
        .map(|x| x.to_digit(10).unwrap())
        .rev()
        .enumerate()
        .map(|(idx, val)| {
            if idx % 2 == 0 {
                val
            } else if val * 2 >= 10 {
                val * 2 - 9
            } else {
                val * 2
            }
        })
        .collect::<Vec<u32>>();

    let luhn_sum: u32 = lunh_seq.iter().sum();
    if luhn_sum % 10 == 0 {
        luhn_sum != 0 || (luhn_sum == 0 && lunh_seq.len() > 1)
    } else {
        false
    }
}
