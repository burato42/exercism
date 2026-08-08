use std::collections::{HashMap, HashSet};

pub struct School {
    students: HashMap<u32, Vec<String>>,
    names: HashSet<String>,
}

impl School {
    pub fn new() -> School {
        Self { students: HashMap::new(), names: HashSet::new() }
    }

    pub fn add(&mut self, grade: u32, student: &str) {
        let student_str = String::from(student);
        if self.names.contains(&student_str) {
            return ();
        }
        let _ = &self.names.insert(student_str.clone());
        
        let list = &self.students.get(&grade);
        
        if list.is_none() {
            let _ = &self.students.insert(grade, vec![student_str]);
        } else {
            let mut updated_list = list.unwrap().clone();
            updated_list.push(student_str);
            println!("{:?}", updated_list);
            let _ = &self.students.insert(grade, updated_list.to_vec());
            println!("{:?}", &self.students.get(&grade));
        }
        ()
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
        let mut names = self.students.get(&grade).cloned().unwrap_or(Vec::<String>::new()).clone();
        names.sort();
        names
    }
}
