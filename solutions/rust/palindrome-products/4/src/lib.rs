use std::collections::HashSet;

#[derive(Debug, Clone, PartialEq, Eq)]
pub struct Palindrome {
    value: u64,
    pairs: HashSet<(u64, u64)>,
}

impl Palindrome {
    pub fn new(value: u64, pairs: HashSet<(u64, u64)>) -> Self {
        Palindrome { value, pairs }
    }

    pub fn value(&self) -> u64 {
        self.value
    }

    pub fn into_factors(self) -> HashSet<(u64, u64)> {
        self.pairs
    }
}

pub fn palindrome_products(min: u64, max: u64) -> Option<(Palindrome, Palindrome)> {
    let mut max_palindrome = Palindrome::new(0u64, HashSet::new());
    let mut min_palindrome = Palindrome::new(u64::MAX, HashSet::new());

    'outer: for i in (min..=max).rev() {
        for j in (i..=max).rev() {
            let curr_product = i * j;
            if is_palindrome(curr_product) {
                if curr_product > max_palindrome.value {
                    max_palindrome = Palindrome::new(curr_product, HashSet::from([(i, j)]));
                } else if curr_product == max_palindrome.value {
                    max_palindrome.pairs.insert((i, j));
                }
            }
            if i * max < max_palindrome.value {
                break 'outer;
            }
            if i * j <= max_palindrome.value {
                break;
            }
        }
    }

    'outer: for i in min..=max {
        for j in i..=max {
            let curr_product = i * j;
            if is_palindrome(curr_product) {
                if curr_product < min_palindrome.value {
                    min_palindrome = Palindrome::new(curr_product, HashSet::from([(i, j)]));
                } else if curr_product == min_palindrome.value {
                    min_palindrome.pairs.insert((i, j));
                }
            }
            if i * i > min_palindrome.value {
                break 'outer;
            }
            if i * j >= min_palindrome.value {
                break;
            }
        }
    }

    if max_palindrome.value == 0u64 || min_palindrome.value == u64::MAX {
        return None;
    }
    Some((min_palindrome, max_palindrome))
}

fn is_palindrome(val: u64) -> bool {
    let mut n = val;
    let mut rev = 0u64;
    while n > 0 {
        rev = rev * 10 + n % 10;
        n /= 10
    }
    val == rev
}
