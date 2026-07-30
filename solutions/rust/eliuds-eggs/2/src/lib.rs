pub fn egg_count(display_value: u32) -> usize {
    display_value.count_ones() as usize
//     let mut counter = 0;
//     while display_value > 0 {
//         if display_value & 1u32 == 1 {
//             counter += 1
//         }
//         display_value >>= 1;
//     }
//     counter
}
