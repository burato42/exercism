pub fn find(array: &[i32], key: i32) -> Option<usize> {
    // array.binary_search(&key).ok()
    if array.is_empty() {
        return None;
    }

    let mut left: usize = 0;
    let mut right: usize = array.len() - 1;

    while left <= right {
        let mid = (right - left) / 2 + left;
        if array[mid] == key {
            return Some(mid);
        } else if array[mid] > key {
            if mid == 0 {
                break;
            }
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    None
}
