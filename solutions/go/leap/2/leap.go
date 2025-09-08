package leap

import "time"

// Checks if the year leap
func IsLeapYear(year int) bool {
	month := time.Month(2)
	day := 29

	date := time.Date(year, month, day, 0, 0, 0, 0, time.UTC)
	return date.Day() == day
}
