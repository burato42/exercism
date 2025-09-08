package etl

import "strings"

func Transform(in map[int][]string) map[string]int {
	m := make(map[string]int)
	for point, letters := range in {
		for _, letter := range letters {
			m[strings.ToLower(letter)] = point
		}
	}
	return m
}
