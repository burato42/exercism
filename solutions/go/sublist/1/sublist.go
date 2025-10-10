package sublist

import (
	"reflect"
)

// Relation type is defined in relations.go file.

// Checks if l1 contain l2
func contain(l1, l2 []int) bool {
	if len(l1) < len(l2) {
		return contain(l2, l1)
	}

	if len(l2) == 0 {
		return true
	}
    for i := 0; i <= len(l1)-len(l2); i++ {
        match := true
        for j := range l2 {
            if l1[i+j] != l2[j] {
                match = false
                break
            }
        }
        if match {
            return true
        }
    }
    return false
}


func Sublist(l1, l2 []int) Relation {
	switch {
	case reflect.DeepEqual(l1, l2):
		return RelationEqual
	case len(l1) > len(l2) && contain(l1, l2):
		return RelationSuperlist
	case len(l1) < len(l2) && contain(l2, l1):
		return RelationSublist
	default:
		return RelationUnequal
	}
}