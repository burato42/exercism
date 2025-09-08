package reverse

func Reverse(input string) string {
	res := ""
	for _, char := range input {
		res = string(char) + res
	}

	return res
}
