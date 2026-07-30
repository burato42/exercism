const CHILDREN: [&str; 12] = [
    "Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph",
    "Kincaid", "Larry",
];

fn plant_name(code: char) -> &'static str {
    match code {
        'G' => "grass",
        'C' => "clover",
        'R' => "radishes",
        'V' => "violets",
        _ => panic!("unknown plant code: {code}"),
    }
}

pub fn plants(diagram: &str, student: &str) -> Vec<&'static str> {
    let student_idx = CHILDREN.iter().position(|&x| x == student).unwrap();
    let start = 2 * student_idx;

    diagram
        .lines()
        .flat_map(|row| {
            let row: Vec<char> = row.chars().collect();
            [row[start], row[start + 1]]
        })
        .map(plant_name)
        .collect()
}
