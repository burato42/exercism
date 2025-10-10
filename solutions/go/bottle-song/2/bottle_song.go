package bottlesong

import (
	"fmt"
	"strings"
)

var numbers = map[int]string{
	10: "Ten",
	9:  "Nine",
	8:  "Eight",
	7:  "Seven",
	6:  "Six",
	5:  "Five",
	4:  "Four",
	3:  "Three",
	2:  "Two",
	1:  "One",
}

func Recite(startBottles, takeDown int) []string {
	res := make([]string, 50)
	chorus := 0

	for i := startBottles; i > startBottles-takeDown; i-- {

		bottleCnt, ok := numbers[i]
		if !ok {
			panic("impossible input")
		}
		if i == 1 {
			res[5*chorus] = "One green bottle hanging on the wall,"
			res[5*chorus+1] = "One green bottle hanging on the wall,"
			res[5*chorus+2] = "And if one green bottle should accidentally fall,"
			res[5*chorus+3] = "There'll be no green bottles hanging on the wall."
		} else {
			res[5*chorus] = fmt.Sprintf("%s green bottles hanging on the wall,", bottleCnt)
			res[5*chorus+1] = fmt.Sprintf("%s green bottles hanging on the wall,", bottleCnt)
			res[5*chorus+2] = "And if one green bottle should accidentally fall,"
			remCnt, ok := numbers[i-1]
			if !ok {
				panic("impossible input")
			}
			if i == 2 {
				res[5*chorus+3] = "There'll be one green bottle hanging on the wall."
			} else {
				res[5*chorus+3] = fmt.Sprintf("There'll be %s green bottles hanging on the wall.", strings.ToLower(remCnt))
			}
		}
		res[5*chorus+4] = ""
		chorus++

	}

	return res[:5*takeDown-1]
}
