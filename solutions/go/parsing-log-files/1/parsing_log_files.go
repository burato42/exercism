package parsinglogfiles

import (
	"regexp"
	"strings"
)

func IsValidLine(text string) bool {
	re := regexp.MustCompile(`^\[(TRC|DBG|INF|WRN|ERR|FTL\])`)
	return re.MatchString(text)
}

func SplitLogLine(text string) []string {
	re := regexp.MustCompile(`<[~*=-]*>`)
	return re.Split(text, -1)
}

func CountQuotedPasswords(lines []string) int {
	re := regexp.MustCompile(`(?i)".*password.*"`)
	cnt := 0
	for _, line := range lines {
		if re.MatchString(line) {
			cnt++
		}
	}
	return cnt
}

func RemoveEndOfLineText(text string) string {
	re := regexp.MustCompile(`end-of-line\d*`)
	return re.ReplaceAllString(text, "")
}

func TagWithUserName(lines []string) []string {
	var tagged []string
	re := regexp.MustCompile(`User\s+\w+\d*`)
	for _, line := range lines {
		if re.MatchString(line) {
			tagged = append(tagged, "[USR] " + strings.TrimSpace(re.FindString(line)[5:]) + " " + line)
		} else {
			tagged = append(tagged, line)
		}
	}
	return tagged
}
