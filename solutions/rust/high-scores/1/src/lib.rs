#[derive(Debug)]
pub struct HighScores<'a> {
    scores: &'a [u32],
}

impl<'a> HighScores<'a> {
    pub fn new(scores: &'a [u32]) -> Self {
        Self { scores }
    }

    pub fn scores(&self) -> &[u32] {
        self.scores
    }

    pub fn latest(&self) -> Option<u32> {
        self.scores.last().as_ref().map(|x| **x)
        // match &self.scores.last() {
        //     Some(x) => Some(**x),
        //     _ => None,
        // }
    }

    pub fn personal_best(&self) -> Option<u32> {
        self.scores.iter().max().as_ref().map(|x| **x)
        // match &self.scores.iter().max() {
        //     Some(x) => Some(**x),
        //     _ => None,
        // }
    }

    pub fn personal_top_three(&self) -> Vec<u32> {
        let mut result: Vec<u32> = self.scores.to_vec();
        result.sort();
        let mut ans = result[result.len().saturating_sub(3)..].to_vec();
        ans.reverse();
        ans
    }
}
