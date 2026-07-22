/// Check a Luhn checksum.
pub fn is_valid(code: &str) -> bool {
    // let no_space: Vec<char> = code.chars().filter(|x| *x != ' ').collect();

    // let only_digits: Vec<_> = no_space.iter().filter(|x| x.is_ascii_digit()).collect();

    // if no_space.len() != only_digits.len() {
    //     return false;
    // }

    // let lunh_seq = only_digits
    //     .iter()
    //     .map(|x| x.to_digit(10).unwrap())
    //     .rev()
    //     .enumerate()
    //     .map(|(idx, val)| {
    //         if idx % 2 == 0 {
    //             val
    //         } else if val * 2 >= 10 {
    //             val * 2 - 9
    //         } else {
    //             val * 2
    //         }
    //     })
    //     .collect::<Vec<u32>>();

    // let luhn_sum: u32 = lunh_seq.iter().sum();
    // if luhn_sum.is_multiple_of(10) {
    //     luhn_sum != 0 || (luhn_sum == 0 && lunh_seq.len() > 1)
    // } else {
    //     false
    // }
    code.chars()
    .rev()
    .filter(|c| !c.is_whitespace())
    .try_fold((0, 0), |(sum, count), val| {
        val.to_digit(10)
            .map(|num| if count % 2 == 1 { num * 2 } else { num })
            .map(|num| if num > 9 { num - 9 } else { num })
            .map(|num| (num + sum, count + 1))
    }).map_or(false, |(sum, count)| sum % 10 == 0 && count > 1)
}
