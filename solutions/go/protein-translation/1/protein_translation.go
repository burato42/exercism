package protein

import (
	"errors"
)

var ErrStop = errors.New("stop codon")
var ErrInvalidBase = errors.New("invalid base")

var codonToAminoAcid = map[string]string{
	"AUG": "Methionine",
	"UUU": "Phenylalanine",
	"UUC": "Phenylalanine",
	"UUA": "Leucine",
	"UUG": "Leucine",
	"UCU": "Serine",
	"UCC": "Serine",
	"UCA": "Serine",
	"UCG": "Serine",
	"UAU": "Tyrosine",
	"UAC": "Tyrosine",
	"UGU": "Cysteine",
	"UGC": "Cysteine",
	"UGG": "Tryptophan",
	"UAA": "STOP",
	"UAG": "STOP",
	"UGA": "STOP",
}

func FromRNA(rna string) ([]string, error) {
	aminoAcids := []string{}
	for i := 0; i <= len(rna)-3; i += 3 {
		acid, err := FromCodon(rna[i : i+3])
		switch {
		case err == ErrStop:
			return aminoAcids, nil
		case err == ErrInvalidBase:
			return nil, ErrInvalidBase
		default:
			aminoAcids = append(aminoAcids, acid)
		}
	}
	return aminoAcids, nil
}

func FromCodon(codon string) (string, error) {
	aminoAcid, ok := codonToAminoAcid[codon]
	if !ok {
		return "", ErrInvalidBase
	}
	if aminoAcid == "STOP" {
		return "", ErrStop
	}
	return aminoAcid, nil
}
