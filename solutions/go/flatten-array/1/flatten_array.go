package flatten

import "reflect"


func Flatten(nested interface{}) []interface{} {
	res := make([]interface{}, 0)
	var traverse func(obj interface{})
	
	traverse = func(obj interface{}) {
		val := reflect.ValueOf(obj)

		if !val.IsValid() {
			return 
		}

		kind := val.Kind()

		if kind == reflect.Slice || kind == reflect.Array {		
			for i := 0; i < val.Len(); i++ {
				element := val.Index(i).Interface()
				traverse(element)
			}
		} else {
			res = append(res, obj)
		}
	}
	
	traverse(nested)
	return res
}
