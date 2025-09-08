package strand

func ToRNA(dna string) string {
	var rna string
	complement := map[rune]string{
		'G': "C",
		'C': "G",
		'T': "A",
		'A': "U"}
	for _, nucleotide := range dna {
		rna += complement[nucleotide]
	}
	return rna
}
