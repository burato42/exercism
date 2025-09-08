package raindrops

import "strconv"

type Sound struct {
	number int
	value  string
}

func Convert(number int) string {
	res := ""
	sounds := []Sound{
		{3, "Pling"},
		{5, "Plang"},
		{7, "Plong"},
	}

	for _, sound := range sounds {
		if number%sound.number == 0 {
			res += sound.value
		}
	}

	if res == "" {
		res = strconv.Itoa(number)
	}

	return res
}
