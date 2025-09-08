package isogram

import "unicode"


func IsIsogram(word string) bool {
	uniq := make(map[rune]struct{})
	var uniChar rune

	for _, char := range word {
		if char == '-' || char == ' ' {
			continue
		}
		
		uniChar = unicode.ToLower(char)
		_, ok := uniq[uniChar]
		if ok {
			return false
		} else {
			uniq[uniChar] = struct{}{}
		}
	}
	return true
}
