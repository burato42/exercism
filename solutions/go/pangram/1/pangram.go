package pangram

import "unicode"

func IsPangram(input string) bool {
	counter := map[rune]int{}
	for _, letter := range input {
		if !unicode.IsLetter(letter) {
			continue
		}

		if _, ok := counter[unicode.ToLower(letter)]; ok {
			counter[unicode.ToLower(letter)] += 1
		} else {
			counter[unicode.ToLower(letter)] = 1
		}
	}
	return len(counter) == 26
}
