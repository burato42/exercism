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
	var start, end int
	switch wSched {
	case First:
		start = 1
		end = 7
	case Second:
		start = 8
		end = 14
	case Third:
		start = 15
		end = 21
	case Fourth:
		start = 22
		end = 28
	case Teenth:
		start = 13
		end = 19
	case Last:
		dayCnt := daysInMonth(month, year)
		start = dayCnt-7
		end = dayCnt
	}

	for day := start; day <= end; day++ {
		if time.Date(year, month, day, 0, 0, 0, 0, time.UTC).Weekday() == wDay {
			return day
		}
	}
	
	return 0
}
