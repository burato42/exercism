package luhn

import (
	"strconv"
	"strings"
)

func Valid(id string) bool {
	cleaned := strings.ReplaceAll(id, " ", "")
	
	if len(cleaned) <= 1 {
		return false
	}
	sum := 0
	
	for i := 0; i < len(cleaned); i++  {
		curEl := cleaned[len(cleaned) - i - 1]
		cur, err := strconv.Atoi(string(curEl))
		
		if err != nil {
			return false
		}
		
		if i%2 == 0 {
			sum += cur
		} else if cur * 2 >= 10 {
			sum += (cur * 2)%10 + 1
		} else {
			sum += cur * 2
		}
	}

	return sum%10 == 0
}
