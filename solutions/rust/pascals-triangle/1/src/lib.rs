pub struct PascalsTriangle {
    rows: Vec<Vec<u32>>,
}

impl PascalsTriangle {
    pub fn new(row_count: u32) -> Self {
        let mut rows: Vec<Vec<u32>> = Vec::new();
        for row in 0..row_count {
            if row == 0 {
                rows.push(vec![1]);
            } else if row == 1 {
                rows.push(vec![1, 1]);
            } else {
                let mut temp_row: Vec<u32> = vec![1];
                for idx in 1..row {
                    temp_row.push(
                        rows.last()
                            .and_then(|inner| {
                                inner
                                    .get(idx as usize - 1)
                                    .zip(inner.get(idx as usize))
                                    .map(|(a, b)| a + b)
                            })
                            .unwrap(),
                    );
                }
                temp_row.push(1);
                rows.push(temp_row);
            }
        }

        Self { rows }
    }

    pub fn rows(&self) -> Vec<Vec<u32>> {
        self.rows.to_vec()
    }
}
