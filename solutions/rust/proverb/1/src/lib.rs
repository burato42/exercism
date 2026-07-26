pub fn build_proverb(list: &[&str]) -> String {
    if list.is_empty() {
        return String::new();
    }

    let ending = format!("And all for the want of a {}.", list.first().unwrap());
    if list.len() == 1 {
        return ending;
    }

    let res = list
        .windows(2)
        .map(|s| format!("For want of a {} the {} was lost.", s[0], s[1]))
        .collect::<Vec<String>>()
        .join("\n");

    res + "\n" + &ending
}
