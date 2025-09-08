package isogram

import "strings"

func IsIsogram(word string) bool {
	uniq := make(map[rune]struct{})

	for _, char := range strings.ToLower(word) {
		if char == '-' || char == ' ' {
			continue
		}

		_, ok := uniq[char]
		if ok {
			return false
		} else {
			uniq[char] = struct{}{}
		}
	}
	return true
}
