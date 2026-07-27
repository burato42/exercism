pub fn raindrops(n: u32) -> String {
    const SOUNDS: [(u32, &str); 3] = [(3, "Pling"), (5, "Plang"), (7, "Plong")];

    let result: String = SOUNDS
        .iter()
        .filter(|(divisor, _)| n.is_multiple_of(*divisor))
        .map(|(_, sound)| *sound)
        .collect();

    if result.is_empty() {
        n.to_string()
    } else {
        result
    }
}
