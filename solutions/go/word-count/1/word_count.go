package wordcount

import "strings"

type Frequency map[string]int

func WordCount(phrase string) Frequency {
	freq := Frequency{}
	separators := "&@$%^&:!?,.; \t\n"
	for _, word := range strings.FieldsFunc(phrase, func(r rune) bool {
		return strings.ContainsRune(separators, r)
	}) {
		if word != "" && word != "'" {
			word = strings.ToLower(strings.Trim(word, "'"))
			freq[word]++
		}
	}
	return freq

}
