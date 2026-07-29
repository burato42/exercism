pub fn collatz(n: u64) -> Option<u64> {
    fn helper(n: u64, counter: u64) -> Option<u64> {
        match n {
            0 => None,
            1 => Some(counter),
            x if x.is_multiple_of(2) => helper(n / 2, counter + 1),
            _ => helper(3 * n + 1, counter + 1),
        }
    }
    helper(n, 0)
}
