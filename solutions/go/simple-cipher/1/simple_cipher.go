package cipher

import (
	"strings"
	"unicode"
)

// Define the shift and vigenere types here.
// Both types should satisfy the Cipher interface.

type shift struct {
	dist int
}

type vigenere struct {
	key string
}

func NewCaesar() Cipher {
	return shift{3}
}

func NewShift(distance int) Cipher {
	if distance == 0 || distance < -25 || distance > 25 {
		return nil
	}
	if distance < 0 {
		return shift{26 + distance}
	}
	return shift{distance}
}

func (c shift) Encode(input string) string {
	var encoded strings.Builder
	for _, char := range input {
		if unicode.IsLetter(char) {
			shift := (unicode.ToLower(char) - 'a' + rune(c.dist)) % 26
			encoded.WriteRune('a' + shift)
		}
	}
	return encoded.String()
}

func (c shift) Decode(input string) string {
	var decoded strings.Builder
	for _, char := range input {
		if unicode.IsLetter(char) {
			shift := (unicode.ToLower(char) - 'a' - rune(c.dist) + 26) % 26
			decoded.WriteRune(shift + 'a')
		}
	}
	return decoded.String()
}

func NewVigenere(key string) Cipher {
	allA := true
	for _, char := range key {
		if char > 'z' || char < 'a' {
			return nil
		}
		if char != 'a' {
			allA = false
		}
	}
	if allA {
		return nil
	}
	return vigenere{key}
}

func (v vigenere) Encode(input string) string {
	var encoded strings.Builder
	charCounter := 0
	for _, char := range input {
		if unicode.IsLetter(char) {
			shift := (unicode.ToLower(char) - 2*'a' + rune(v.key[charCounter%len(v.key)])) % 26
			encoded.WriteRune('a' + shift)
			charCounter++
		}
	}
	return encoded.String()
}

func (v vigenere) Decode(input string) string {
	var decoded strings.Builder
	charCounter := 0
	for _, char := range input {
		if unicode.IsLetter(char) {
			shift := (unicode.ToLower(char) - rune(v.key[charCounter%len(v.key)]) + 26) % 26
			decoded.WriteRune(shift + 'a')
			charCounter++
		}
	}
	return decoded.String()
}
