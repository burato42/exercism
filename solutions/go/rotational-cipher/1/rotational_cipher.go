package rotationalcipher

func RotationalCipher(plain string, shiftKey int) string {
	encrypted := ""
	alphabetSize := 26
	for _, char := range plain {
		if char >= 'a' && char <= 'z' {
			encrypted += string(rune(int('a') + (int(char)-int('a')+shiftKey)%alphabetSize))
		} else if char >= 'A' && char <= 'Z' {
			encrypted += string(rune(int('A') + (int(char)-int('A')+shiftKey)%alphabetSize))
		} else {
			encrypted += string(char)
		}
	}

	return encrypted
}
