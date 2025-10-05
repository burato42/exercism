package atbash

import (
	"strings"
	"unicode"
)

func Atbash(s string) string {
	var encrypted strings.Builder
	counter := 0

	for _, char := range s {
		if unicode.IsLetter(char) {
			encrypted.WriteRune('z' - (unicode.ToLower(char) - 'a'))
		} else if unicode.IsDigit(char) {
			encrypted.WriteRune(char)
		} else {
			continue
		}
		counter += 1
		if counter%5 == 0 {
			encrypted.WriteRune(' ')
		}
	}

	return strings.TrimSpace(encrypted.String())
}
