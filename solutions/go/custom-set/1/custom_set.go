package stringset

import (
	"reflect"
	"strings"
)

// Implement Set as a collection of unique string values.
//
// For Set.String, use '{' and '}', output elements as double-quoted strings
// safely escaped with Go syntax, and use a comma and a single space between
// elements. For example, a set with 2 elements, "a" and "b", should be formatted as {"a", "b"}.
// Format the empty set as {}.

// Define the Set type here.
type Set map[string]struct{}

func New() Set {
	return make(Set)
}

func NewFromSlice(l []string) Set {
	set := New()
	for _, str := range l {
		set[str] = struct{}{}
	}
	return set
}

func (s Set) String() string {
	res := make([]string, len(s))
	i := 0
	for key := range s {
		res[i] = "\"" + key + "\""
		i++
	}
	if len(res) == 0 {
		return "{}"
	}
	return "{" + strings.Join(res, ", ") + "}"
}

func (s Set) IsEmpty() bool {
	return len(s) == 0
}

func (s Set) Has(elem string) bool {
	_, ok := s[elem]
	return ok
}

func (s Set) Add(elem string) {
	s[elem] = struct{}{}
}

func Subset(s1, s2 Set) bool {
	for key := range s1 {
		if _, ok := s2[key]; !ok {
			return false
		}
	}
	return true
}

func Disjoint(s1, s2 Set) bool {
	for key := range s1 {
		if _, ok := s2[key]; ok {
			return false
		}
	}
	for key := range s2 {
		if _, ok := s1[key]; ok {
			return false
		}
	}

	return true
}

func Equal(s1, s2 Set) bool {
	return reflect.DeepEqual(s1, s2)
}

func Intersection(s1, s2 Set) Set {
	newSet := New()
	for key1 := range s1 {
		if _, ok := s2[key1]; ok {
			newSet.Add(key1)
		}
	}
	return newSet
}

func Difference(s1, s2 Set) Set {
	newSet := New()
	for key1 := range s1 {
		if _, ok := s2[key1]; !ok {
			newSet.Add(key1)
		}
	}
	return newSet
}

func Union(s1, s2 Set) Set {
	newSet := New()
	for key1 := range s1 {
		newSet.Add(key1)
	}
	for key2 := range s2 {
		newSet.Add(key2)
	}
	return newSet
}
