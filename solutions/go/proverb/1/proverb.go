package proverb

import "fmt"

func Proverb(rhyme []string) []string {
	linesCnt := len(rhyme)
	if linesCnt == 0 {
		return []string{}
	}

	poem := make([]string, linesCnt)
	for i := 0; i < len(rhyme)-1; i++ {
		poem[i] = fmt.Sprintf("For want of a %s the %s was lost.", rhyme[i], rhyme[i+1])
	}
	poem[linesCnt-1] = fmt.Sprintf("And all for the want of a %s.", rhyme[0])
	return poem
}
