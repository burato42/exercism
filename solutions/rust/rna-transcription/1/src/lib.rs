use std::collections::HashMap;

const DNA_NUCLEOTIDES: [char; 4] = ['G', 'C', 'T', 'A'];
const RNA_NUCLEOTIDES: [char; 4] = ['C', 'G', 'A', 'U'];

#[derive(Debug, PartialEq, Eq)]
pub struct Dna {
    nucleotides: Vec<char>,
}

#[derive(Debug, PartialEq, Eq)]
pub struct Rna {
    nucleotides: Vec<char>,
}

impl Dna {
    pub fn new(dna: &str) -> Result<Dna, usize> {
        for (idx, nucleotide) in dna.char_indices() {
            if !DNA_NUCLEOTIDES.contains(&nucleotide) {
                return Err(idx);
            }
        }
        Ok(Dna {
            nucleotides: dna.chars().collect(),
        })
    }

    pub fn into_rna(self) -> Rna {
        let mapping: HashMap<&char, char> = DNA_NUCLEOTIDES.iter().zip(RNA_NUCLEOTIDES).collect();
        Rna {
            nucleotides: self
                .nucleotides
                .iter()
                .map(|x| *mapping.get(x).unwrap())
                .collect::<Vec<char>>(),
        }
    }
}

impl Rna {
    pub fn new(rna: &str) -> Result<Rna, usize> {
        for (idx, nucleotide) in rna.char_indices() {
            if !RNA_NUCLEOTIDES.contains(&nucleotide) {
                return Err(idx);
            }
        }
        Ok(Rna {
            nucleotides: rna.chars().collect(),
        })
    }
}
