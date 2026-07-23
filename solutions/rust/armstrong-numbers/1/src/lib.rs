pub fn is_armstrong_number(num: u32) -> bool {
    let mut counter = 0;
    let mut curr_num = num;
    while curr_num != 0 {
        curr_num /= 10;
        counter += 1;
    }
    let mut curr_num = num;
    let mut sum = 0;
    while curr_num != 0 {
        sum += (curr_num % 10).pow(counter);
        curr_num /= 10;
    }
    sum == num
}
