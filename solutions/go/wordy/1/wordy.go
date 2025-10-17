package wordy

import (
	"regexp"
	"strconv"
)

func Answer(question string) (int, bool) {
	initial := regexp.MustCompile(`What is (-?\d+)(?: (?:(plus|minus|multiplied by|divided by) (-?\d+)))*\?`)
	if len(initial.FindStringSubmatch(question)) == 0 {
		return 0, false
	}
	primaryPattern := regexp.MustCompile(`What is (-?\d+)(.*)\?`)
	secondaryPattern := regexp.MustCompile(`\s+(plus|minus|multiplied by|divided by)\s+(-?\d+)`)

	matches := primaryPattern.FindStringSubmatch(question)
	if len(matches) < 2 {
		return 0, false
	}
	initialNumber, err := strconv.Atoi(matches[1])
	if err != nil {
		return 0, false
	}

	operationChain := matches[2]

	numbers := make([]int, 0)

	numbers = append(numbers, initialNumber)

	operationMatches := secondaryPattern.FindAllStringSubmatch(operationChain, -1)
	if len(operationMatches) == 0 && operationChain != "" {
		return 0, false
	}
	for _, match := range operationMatches {
		operand := match[1]
		value, err := strconv.Atoi(match[2])

		if err != nil {
			panic("should be a number")
		}

		switch operand {
		case "multiplied by":
			val := numbers[len(numbers)-1] * value
			numbers[len(numbers)-1] = val
		case "divided by":
			val := numbers[len(numbers)-1] / value
			numbers[len(numbers)-1] = val
		case "minus":
			val := numbers[len(numbers)-1] - value
			numbers[len(numbers)-1] = val
		default:
			val := numbers[len(numbers)-1] + value
			numbers[len(numbers)-1] = val
		}
	}

	if len(numbers) == 0 {
		return 0, false
	}

	return numbers[0], true
}
