//As it's just an exercise I keep it like this
package gigasecond

import "time"

// Adds a gigasecond to a specific time
func AddGigasecond(t time.Time) time.Time {
	const gigasecond = 1e9
	return t.Add(time.Second * gigasecond)
}
