const DNA_NUCLEOTIDES: [char; 4] = ['G', 'C', 'T', 'A'];
const RNA_NUCLEOTIDES: [char; 4] = ['C', 'G', 'A', 'U'];

#[derive(Debug, PartialEq, Eq)]
pub struct Dna {
    nucleotides: String,
}

#[derive(Debug, PartialEq, Eq)]
pub struct Rna {
    nucleotides: String,
}


fn validate(strand: &str, valid: &[char]) -> Result<(), usize> {
    match strand.chars().position(|c| !valid.contains(&c)) {
        Some(idx) => Err(idx),
        None => Ok(()),
    }
}

impl Dna {
    pub fn new(dna: &str) -> Result<Dna, usize> {
        validate(dna, &DNA_NUCLEOTIDES)?;
        Ok(Dna {
            nucleotides: dna.to_string(),
        })
    }

    pub fn into_rna(self) -> Rna {
        Rna {
            nucleotides: self
                .nucleotides
                .chars()
                .map(|c| match c {
                    'G' => 'C',
                    'C' => 'G',
                    'T' => 'A',
                    'A' => 'U',
                    _ => unreachable!("validated in Dna::new"),
                })
                .collect(),
        }
    }
}

impl Rna {
    pub fn new(rna: &str) -> Result<Rna, usize> {
        validate(rna, &RNA_NUCLEOTIDES)?;
        Ok(Rna {
            nucleotides: rna.to_string(),
        })
    }
}
