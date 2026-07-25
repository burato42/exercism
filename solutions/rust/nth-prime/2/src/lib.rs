pub fn nth(n: u32) -> u32 {
    // let mut primes: Vec<u32> = Vec::new();
    // let mut curr_num = 2u32;
    // while primes.len() < n as usize + 1 {
    //     if primes.iter().all(|x| !curr_num.is_multiple_of(*x)) {
    //         primes.push(curr_num);
    //     }
    //     curr_num += 1;
    // }
    // primes.last().unwrap().to_owned()
    let mut primes: Vec<u32> = vec![];
    (2..)
        .filter(|candidate: &u32| {
            if !primes.iter().any(|i| candidate.is_multiple_of(*i)) {
                primes.push(*candidate);
                true
            } else {
                false
            }
        })
        .nth(n as usize)
        .unwrap()
}
