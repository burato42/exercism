package isbn

import "strconv"

func IsValidISBN(isbn string) bool {
	resultSlice := []int{}
	res := 0
	for len(isbn) > 0 {
		char := isbn[0]
		isbn = isbn[1:]
		cur, err := strconv.Atoi(string(char))
		if err == nil {
			resultSlice = append(resultSlice, cur)
		} else if char == 'X' {
			resultSlice = append(resultSlice, 10)
 		} else if char != '-' {
			return false
		}
	} 
	if len(resultSlice) != 10 {
		return false
	}

	for i:=0; i < 10; i++ {
		if i != 9 && resultSlice[i] == 10 {
			return false
		}
		res += (10 - i) * resultSlice[i]
	}

	return res%11 == 0
}
