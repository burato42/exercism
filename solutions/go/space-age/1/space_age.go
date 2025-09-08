package space

type Planet string

func Age(seconds float64, planet Planet) float64 {
	timeCoef := 3600 * 365.25 * 24
	switch planet {
	case "Mercury":
		return seconds / (timeCoef * 0.2408467)
	case "Venus":
		return seconds / (timeCoef * 0.61519726)
	case "Earth":
		return  seconds / timeCoef
	case "Mars":
		return seconds / (timeCoef  * 1.8808158)
	case "Jupiter":
		return seconds / (timeCoef * 11.862615)
	case "Saturn":
		return seconds / ( timeCoef * 29.447498)
	case "Uranus":
		return seconds / (timeCoef * 84.016846)
	case "Neptune":
		return seconds / (timeCoef  * 164.79132)
	default:
		return -1
	}
}
