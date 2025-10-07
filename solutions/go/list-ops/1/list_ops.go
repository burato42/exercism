package listops

// IntList is an abstraction of a list of integers which we can define methods on
type IntList []int

func (s IntList) Foldl(fn func(int, int) int, initial int) int {
	cur := initial
	for i := range s {
		cur = fn(cur, s[i])
	}
	return cur
}

func (s IntList) Foldr(fn func(int, int) int, initial int) int {
	cur := initial
	for i := range s {
		cur = fn(s[len(s)-i-1], cur)
	}
	return cur
}

func (s IntList) Filter(fn func(int) bool) IntList {
	result := make([]int, 0)
	for _, el := range s {
		if fn(el) {
			result = append(result, el)
		}
	}
	return result
}

func (s IntList) Length() int {
	return len(s)
}

func (s IntList) Map(fn func(int) int) IntList {
	result := make([]int, 0)
	for _, el := range s {
		result = append(result, fn(el))
	}
	return result
}

func (s IntList) Reverse() IntList {
	result := make([]int, 0)
	for i := 0; i < s.Length(); i++ {
		result = append(result, s[s.Length()-i-1])
	}
	return result
}

func (s IntList) Append(lst IntList) IntList {
	return append(s, lst...)
}

func (s IntList) Concat(lists []IntList) IntList {
	for _, lst := range lists {
		s = s.Append(lst)
	}
	return s
}
