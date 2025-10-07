package acronym

import "strings"

func Abbreviate(s string) string {
	abbreviation := ""
	separators := " -_"

	parts := strings.FieldsFunc(s, func(r rune) bool {
		return strings.ContainsRune(separators, r)
	})

	for _, substr := range parts {
		abbreviation += strings.ToUpper(string(substr[0]))
	}
	return abbreviation
}
