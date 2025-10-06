package phonenumber

import (
	"errors"
	"fmt"
	"unicode"
)

func Number(phoneNumber string) (string, error) {
	clndNum := ""
	for _, number := range phoneNumber {
		if unicode.IsDigit(number) {
			clndNum += string(number)
		}
	}

	if len(clndNum) == 11 && clndNum[0] == '1' {
		clndNum = clndNum[1:]
	}

	if len(clndNum) != 10 {
		return "", errors.New("wrong phone number")
	}

	if int(clndNum[0]-'0') < 2 || int(clndNum[3]-'0') < 2 {
		return "", errors.New("wrong phone number")
	}

	return clndNum, nil
}

func AreaCode(phoneNumber string) (string, error) {
	number, err := Number(phoneNumber)
	if err != nil {
		return "", err
	}
	return number[:3], nil
}

func Format(phoneNumber string) (string, error) {
	number, err := Number(phoneNumber)
	if err != nil {
		return "", err
	}
	return fmt.Sprintf("(%s) %s-%s", number[0:3], number[3:6], number[6:]), nil
}
