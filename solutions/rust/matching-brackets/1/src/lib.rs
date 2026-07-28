use std::collections::HashMap;

pub fn brackets_are_balanced(string: &str) -> bool {
    let brackets = HashMap::from([('{', '}'), ('(', ')'), ('[', ']')]);
    let only_braces = string
        .chars()
        .filter(|x| brackets.contains_key(&x) || brackets.values().any(|&y| y == *x));

    let mut stack = vec![];
    for x in only_braces {
        if brackets.contains_key(&x) {
            stack.push(x);
        } else if stack.is_empty() {
            return false;
        } else if brackets.get(stack.last().unwrap()).unwrap() == &x {
            stack.pop();
        } else {
            return false;
        }
    }
    stack.is_empty()
}
