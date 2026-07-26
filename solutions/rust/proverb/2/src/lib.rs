pub fn build_proverb(list: &[&str]) -> String {
    let Some(first) = list.first() else {
        return String::new();
    };

    list.windows(2)
        .map(|s| format!("For want of a {} the {} was lost.\n", s[0], s[1]))
        .collect::<String>()
        + &format!("And all for the want of a {first}.")
}
