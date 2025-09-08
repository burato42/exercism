package romannumerals

import "errors"


func ToRomanNumeral(input int) (string, error) {
	if input <= 0 || input >= 4000 {
		return "", errors.New("the range should be 1 to 3999")
	}
	res := ""
	for input > 0 {
		switch {
		case input >= 1000:
			res += "M"
			input -= 1000
		case input >= 900:
			res += "CM"
			input -= 900
		case input >= 500:
			res += "D"
			input -= 500
		case input >= 400:
			res += "CD"
			input -= 400
		case input >= 100:
			res += "C"
			input -= 100
		case input >= 90:
			res += "XC"
			input -= 90
		case input >= 50:
			res += "L"
			input -= 50
		case input >= 40:
			res += "XL"
			input -= 40
		case input >= 10:
			res += "X"
			input -= 10
		case input >= 9:
			res += "IX"
			input -= 9
		case input >= 5:
			res += "V"
			input -= 5
		case input >= 4:
			res += "IV"
			input -= 4
		case input >= 1:
			res += "I"
			input -= 1

		}
	}
	return res, nil
}
