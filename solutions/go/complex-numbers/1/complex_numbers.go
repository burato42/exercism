package complexnumbers

import "math"

// Define the Number type here.
type Number struct {
	real, imag float64
}

func (n Number) Real() float64 {
	return n.real
}

func (n Number) Imaginary() float64 {
	return n.imag
}

func (n1 Number) Add(n2 Number) Number {
	return Number{n1.real + n2.real, n1.imag + n2.imag}
}

func (n1 Number) Subtract(n2 Number) Number {
	return Number{
		n1.real - n2.real,
		n1.imag - n2.imag,
	}
}

func (n1 Number) Multiply(n2 Number) Number {
	return Number{
		n1.real*n2.real - n1.imag*n2.imag,
		n1.real*n2.imag + n1.imag*n2.real,
	}
}

func (n Number) Times(factor float64) Number {
	return Number{n.real * factor, n.imag * factor}
}

func (n1 Number) Divide(n2 Number) Number {
	return Number{
		(n1.real*n2.real + n1.imag*n2.imag) / math.Pow(n2.Abs(), 2),
		(n1.imag*n2.real - n1.real*n2.imag) / math.Pow(n2.Abs(), 2),
	}
}

func (n Number) Conjugate() Number {
	return Number{n.real, -n.imag}
}

func (n Number) Abs() float64 {
	return math.Sqrt(n.real*n.real + n.imag*n.imag)
}

func (n Number) Exp() Number {
	return Number{
		math.Exp(n.real) * math.Cos(n.imag),
		math.Exp(n.real) * math.Sin(n.imag),
	}
}
