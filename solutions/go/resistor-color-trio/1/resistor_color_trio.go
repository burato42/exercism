package resistorcolortrio

import (
	"strconv"
	"strings"
)

// Label describes the resistance value given the colors of a resistor.
// The label is a string with a resistance value with an unit appended
// (e.g. "33 ohms", "470 kiloohms").

var mapping = map[string]int{
	"black":  0,
	"brown":  1,
	"red":    2,
	"orange": 3,
	"yellow": 4,
	"green":  5,
	"blue":   6,
	"violet": 7,
	"grey":   8,
	"white":  9,
}

func Label(colors []string) string {
	zeros := mapping[colors[2]]
	var begin string
	var end string

	firstDigit := mapping[colors[0]]
	secondDigit := mapping[colors[1]]
	if secondDigit == 0 {
		begin = strconv.Itoa(firstDigit)
		zeros += 1
	} else {
		begin = strconv.Itoa(firstDigit*10 + secondDigit)
	}

	switch {
	case zeros < 3:
		end = strings.Repeat("0", zeros) + " ohms"
	case zeros < 6:
		end = strings.Repeat("0", zeros-3) + " kiloohms"
	case zeros < 9:
		end = strings.Repeat("0", zeros-6) + " megaohms"
	case zeros < 12:
		end = strings.Repeat("0", zeros-9) + " gigaohms"
	default:
		panic("this is too much")
	}

	resistance := begin + end
	if strings.HasPrefix(resistance, "0") {
		return resistance[1:]
	}
	return resistance
}
