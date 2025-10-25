package flatten

// import "reflect"


func Flatten(input interface{}) []interface{} {
	flat := []interface{}{}
	
	switch i := input.(type) {
	
	case []interface{}:
		for _, val := range i {
			flat = append(flat, Flatten(val)...)
		}
	case interface{}:
		flat = append(flat, i)
	}
	
	return flat
}
