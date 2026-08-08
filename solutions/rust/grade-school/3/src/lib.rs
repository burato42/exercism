use std::collections::{HashMap, HashSet};

pub struct School {
    students: HashMap<u32, Vec<String>>,
    names: HashSet<String>,
}

impl School {
    pub fn new() -> School {
        Self {
            students: HashMap::new(),
            names: HashSet::new(),
        }
    }

    pub fn add(&mut self, grade: u32, student: &str) {
        if !self.names.insert(student.to_string()) {
            return;
        }
        self.students
            .entry(grade)
            .or_default()
            .push(student.to_string());
    }

    pub fn grades(&self) -> Vec<u32> {
        let mut grades: Vec<u32> = self.students.keys().copied().collect();
        grades.sort();
        grades
    }

    // If `grade` returned a reference, `School` would be forced to keep a `Vec<String>`
    // internally to lend out. By returning an owned vector of owned `String`s instead,
    // the internal structure can be completely arbitrary. The tradeoff is that some data
    // must be copied each time `grade` is called.
    pub fn grade(&self, grade: u32) -> Vec<String> {
        let mut names = self.students.get(&grade).cloned().unwrap_or_default();
        names.sort();
        names
    }
}
