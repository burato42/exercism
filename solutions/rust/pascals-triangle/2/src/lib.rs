pub struct PascalsTriangle {
    rows: Vec<Vec<u32>>,
}

impl PascalsTriangle {
    pub fn new(row_count: u32) -> Self {
        let mut rows = Vec::new();
        if row_count > 0 {
            rows.push(vec![1]);
        }
        if row_count > 1 {
            rows.push(vec![1, 1]);
        }

        for _ in 2..row_count {
            let prev_row = rows.last().unwrap().to_vec();
            let mut temp_row: Vec<u32> = vec![1];
            for window in prev_row.windows(2) {
                temp_row.push(window[0] + window[1]);
            }
            temp_row.push(1);
            rows.push(temp_row);
        }

        Self { rows }
    }

    pub fn rows(&self) -> Vec<Vec<u32>> {
        self.rows.to_vec()
    }
}
