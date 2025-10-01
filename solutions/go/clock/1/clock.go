package clock

import "fmt"

// Define the Clock type here.
type Clock struct {
	hour, minute int
}

const (
	minInHour = 60
	hourInDay = 24
	minInDay  = hourInDay * minInHour
)

func New(h, m int) Clock {
	initialMinutes := modPositive(h*minInHour+m, minInDay)
	hours := modPositive(initialMinutes/minInHour, hourInDay)
	minutes := modPositive(initialMinutes, minInHour)
	return Clock{hours, minutes}
}

func (c Clock) Add(m int) Clock {
	return New(c.hour, c.minute+m)
}

func (c Clock) Subtract(m int) Clock {
	return c.Add(-m)
}

func (c Clock) String() string {
	return fmt.Sprintf("%02d:%02d", c.hour, c.minute)
}

func modPositive(numerator, denominator int) int {
	return (numerator%denominator + denominator) % denominator
}
