pub fn factors(n: u64) -> Vec<u64> {
    let mut prime_factrors: Vec<u64> = vec![];

    let mut curr_n = n;

    while curr_n.is_multiple_of(2) {
        prime_factrors.push(2);
        curr_n /= 2;
    }

    let mut divisor = 3u64;
    while divisor.pow(2) <= curr_n {
        while curr_n.is_multiple_of(divisor) {
            prime_factrors.push(divisor);
            curr_n /= divisor;
        }
        divisor += 2;
    }

    if curr_n > 1 {
        prime_factrors.push(curr_n);
    }
    prime_factrors
}
