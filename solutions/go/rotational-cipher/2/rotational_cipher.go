package rotationalcipher

import "strings"

func RotationalCipher(plain string, shiftKey int) string {
	var encrypted strings.Builder
	const alphabetSize = 26

	for _, char := range plain {
		switch {
		case char >= 'a' && char <= 'z':
            shifted := (char - 'a' + rune(shiftKey)) % alphabetSize
            encrypted.WriteRune('a' + shifted)
		case char >= 'A' && char <= 'Z':
			shifted := (char - 'A' + rune(shiftKey)) % alphabetSize
            encrypted.WriteRune('A' + shifted)
		default:
            encrypted.WriteRune(char)
		}
	}

	return encrypted.String()
}
