use std::collections::HashMap;

pub fn plants(diagram: &str, student: &str) -> Vec<&'static str> {
    let mapping = HashMap::from([
        ('G', "grass"),
        ('C', "clover"),
        ('R', "radishes"),
        ('V', "violets")
    ]);

    let children: Vec<&str> = "Alice, Bob, Charlie, David, Eve, Fred, Ginny, Harriet, Ileana, Joseph, Kincaid, Larry".split(", ").collect();

    let student_idx = children.iter().position(|&x| x == student).unwrap();
    
    let layout: Vec<Vec<char>> = diagram.split("\n").map(|x| x.chars().collect::<Vec<char>>()).collect();
    
    vec![mapping.get(&layout[0][2 * student_idx]).unwrap(), 
        mapping.get(&layout[0][2 * student_idx + 1]).unwrap(),
        mapping.get(&layout[1][2 * student_idx]).unwrap(), 
        mapping.get(&layout[1][2 * student_idx + 1]).unwrap(),
  ]
    
}
