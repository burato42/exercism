package anagram

import (
	"reflect"
	"strings"
	"unicode"
)

func strToFreqMap(str string) map[rune]int {
	freqMap := make(map[rune]int)
	for _, char := range str {
		lowerChar := unicode.ToLower(char)
		freqMap[lowerChar]++
	}
	return freqMap
}

func Detect(subject string, candidates []string) []string {
	anagrams := []string{}
	subjectFreqMap := strToFreqMap(subject)
	for _, candidate := range candidates {
		if !strings.EqualFold(candidate, subject) && reflect.DeepEqual(strToFreqMap(candidate), subjectFreqMap) {
			anagrams = append(anagrams, candidate)
		}
	}

	return anagrams
}
