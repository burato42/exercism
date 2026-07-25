pub fn nth(n: u32) -> u32 {
    let mut primes: Vec<u32> = Vec::new();
    let mut curr_num = 2u32;
    while primes.len() < n as usize + 1 {
        if primes.iter().all(|x| !curr_num.is_multiple_of(*x)) {
            primes.push(curr_num);
        }
        curr_num += 1;
    }
    primes.last().unwrap().to_owned()
}
