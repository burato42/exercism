package pangram

import "unicode"

func IsPangram(input string) bool {
	counter := map[rune]int{}
	for _, letter := range input {
		if !unicode.IsLetter(letter) {
			continue
		}
		
		counter[unicode.ToLower(letter)]++
	}
	return len(counter) == 26
}
