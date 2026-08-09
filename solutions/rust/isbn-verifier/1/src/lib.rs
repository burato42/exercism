/// Determines whether the supplied string is a valid ISBN number
pub fn is_valid_isbn(isbn: &str) -> bool {
    let no_dash = isbn.chars().filter(|x| *x != '-');
    if no_dash.collect::<Vec<char>>().len() != 10 {
        return false;
    }

    let cleaned_isbn = isbn
        .chars()
        .filter(|x| *x == 'X' || x.is_ascii_digit())
        .map(|x| {
            match x {
                el if el == 'X' => 10u32,
                el => el.to_digit(10).unwrap()
            }
        })
        .collect::<Vec<u32>>();

    if cleaned_isbn.len() != 10 {
        return false;
    }
    if cleaned_isbn[0..9].contains(&10) {return false;}

    cleaned_isbn
        .iter()
        .zip((1..=10).rev())
        .map(|(x, y)| x * y)
        .sum::<u32>() % 11 == 0

}
