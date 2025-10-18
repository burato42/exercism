package meetup

import "time"

// Define the WeekSchedule type here.
type WeekSchedule int 

const (
	First WeekSchedule = iota
	Second
	Third
	Fourth
	Teenth
	Last
)

func daysInMonth(month time.Month, year int) int {
    return time.Date(year, month+1, 0, 0, 0, 0, 0, time.UTC).Day()
}

func Day(wSched WeekSchedule, wDay time.Weekday, month time.Month, year int) int {
	var dayRange []int
	switch wSched {
	case First:
		dayRange = []int{1, 2, 3, 4, 5, 6, 7}
	case Second:
		dayRange = []int{8, 9, 10, 11, 12, 13, 14}
	case Third:
		dayRange = []int{15, 16, 17, 18, 19, 20, 21}
	case Fourth:
		dayRange = []int{22, 23, 24, 25, 26, 27, 28}
	case Teenth:
		dayRange = []int{13, 14, 15, 16, 17, 18, 19}
	case Last:
		dayCnt := daysInMonth(month, year)
		dayRange = []int{dayCnt, dayCnt-1, dayCnt-2, dayCnt-3, dayCnt-4, dayCnt-5, dayCnt-6, dayCnt-7}
	}

	for _, day := range dayRange {
		if time.Date(year, month, day, 0, 0, 0, 0, time.UTC).Weekday() == wDay {
			return day
		}
	}
	
	return 0
}
