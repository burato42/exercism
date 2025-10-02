// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package triangle used to check the type of the tiangle
// https://golang.org/doc/effective_go.html#commentary
package triangle

type Kind int

const (
	NaT Kind = iota // not a triangle
	Equ             // equilateral
	Iso             // isosceles
	Sca             // scalene
)

// Defines what sort of triangles can be formed
func KindFromSides(a, b, c float64) Kind {
	// Float comparison might not always be correct
	if a <= 0 || b <= 0 || c <= 0 {
		return NaT
	}

	switch {
	case a+b < c || a+c < b || b+c < a:
		return NaT
	case a == b && b == c:
		return Equ
	case a == b || b == c || c == a:
		return Iso
	default:
		return Sca
	}
}
