pub fn annotate(garden: &[&str]) -> Vec<String> {
    let length = garden.len();
    if length == 0 {
        return Vec::new();
    }
    let width = garden[0].len();
    let mut rows: Vec<Vec<u8>> = garden.iter().map(|row| row.as_bytes().to_vec()).collect();

    for i in 0..length {
        for j in 0..width {
            if garden[i].as_bytes()[j] != b'*' {
                let mut counter = 0;
                for (di, dj) in &[
                    (-1, -1),
                    (-1, 0),
                    (-1, 1),
                    (0, -1),
                    (0, 1),
                    (1, -1),
                    (1, 0),
                    (1, 1),
                ] {
                    let ni = i as isize + di;
                    let nj = j as isize + dj;
                    if ni >= 0
                        && nj >= 0
                        && (ni as usize) < length
                        && (nj as usize) < width
                        && garden[ni as usize].as_bytes()[nj as usize] == b'*'
                    {
                        counter += 1;
                    }
                }
                if counter != 0 {
                    rows[i][j] = b'0' + counter;
                }
            }
        }
    }

    rows.into_iter()
        .map(|row| String::from_utf8(row).unwrap())
        .collect()
}
