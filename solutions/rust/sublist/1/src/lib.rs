#[derive(Debug, PartialEq, Eq)]
pub enum Comparison {
    Equal,
    Sublist,
    Superlist,
    Unequal,
}

fn contains(bigger_list: &[i32], smaller_list: &[i32]) -> bool {
    if smaller_list.is_empty() {
        return true;
    }
    if bigger_list.len() < smaller_list.len() {
        return false;
    }

    for i in 0..=bigger_list.len() - smaller_list.len() {
        for j in 0..smaller_list.len() {
            if bigger_list[i + j] != smaller_list[j] {
                break;
            }
            if j == smaller_list.len() - 1 && bigger_list[i + j] == smaller_list[j] {
                return true;
            }
        }
    }
    false
}

pub fn sublist(first_list: &[i32], second_list: &[i32]) -> Comparison {
    if first_list == second_list {
        Comparison::Equal
    } else if contains(first_list, second_list) {
        Comparison::Superlist
    } else if contains(second_list, first_list) {
        Comparison::Sublist
    } else {
        Comparison::Unequal
    }
}
