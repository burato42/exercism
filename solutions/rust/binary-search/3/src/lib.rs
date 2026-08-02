pub fn find(array: &[i32], key: i32) -> Option<usize> {
    // array.binary_search(&key).ok()   
    let mut left = 0;
    let mut right = array.len();
    
    while left < right {
        let mid = (right - left) / 2 + left;
        if array[mid] > key {
            right = mid;
        } else if array[mid] < key {
            left = mid + 1;
        } else {
            return Some(mid);
        }
    }
    None
}
