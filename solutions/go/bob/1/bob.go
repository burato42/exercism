package bob

import (
	"regexp"
	"strings"
)

func isQuestion(remark string) bool {
	return strings.HasSuffix(remark, "?")
}

func isYelling(remark string) bool {
	regex := regexp.MustCompile(`^.*[A-Z]+.*$`)
	return strings.ToUpper(remark) == remark  && regex.MatchString(remark)
}


// Hey determines Bob's answer
func Hey(remark string) string {
	cleanedRemark := strings.TrimSpace(remark)
	switch {
	case isQuestion(cleanedRemark) && isYelling(cleanedRemark):
		return "Calm down, I know what I'm doing!"
	case isQuestion(cleanedRemark):
		return "Sure."
	case isYelling(cleanedRemark):
		return "Whoa, chill out!"
	case cleanedRemark == "":
		return "Fine. Be that way!"
	default:
		return "Whatever."
	}
}
