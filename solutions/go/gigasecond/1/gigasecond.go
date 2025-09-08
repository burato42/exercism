//As it's just an exercise I keep it like this
package gigasecond

import "time"

// Adds a gigasecond to a specific time
func AddGigasecond(t time.Time) time.Time {
	const gigasecond = 1000000000
	return time.Unix(t.Unix() + gigasecond, 0)
}
