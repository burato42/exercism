package resistorcolorduo

import (
	"math"
)

// Value should return the resistance value of a resistor with a given colors.
func Value(colors []string) int {
	colorMap := map[string]int{
		"black": 0, "brown": 1, "red": 2, "orange": 3, "yellow": 4,
		"green": 5, "blue": 6, "violet": 7, "grey": 8, "white": 9,
	}
	var res int
	for i, color := range colors {
		if i >= 2 {
			break
		}

		index, ok := colorMap[color]
		if !ok {
			panic("This color is inknown")
		}
		res += index * int(math.Pow10(1 - i))
	}
	return res
}
