pub fn collatz(n: u64) -> Option<u64> {
    if n == 0 {
        return None;
    }
    fn helper(n: u64, counter: u64) -> u64 {
        match n {
            1 => counter,
            x if x.is_multiple_of(2) => helper(n / 2, counter + 1),
            _ => helper(3 * n + 1, counter + 1),
        }
    }
    Some(helper(n, 0))
}
