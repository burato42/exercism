package kindergarten

import (
	"errors"
	"sort"
	"strings"
)

// Define the Garden type here.
type Garden struct{
	rows     []string
	children []string
}

var seeds = map[string]string{
	    "V": "violets",
        "R": "radishes",
        "C": "clover",
        "G": "grass",
}
// The diagram argument starts each row with a '\n'.  This allows Go's
// raw string literals to present diagrams in source code nicely as two
// rows flush left, for example,
//
//     diagram := `
//     VVCCGG
//     VVCCGG`



func NewGarden(diagram string, children []string) (*Garden, error) {
	if !strings.HasPrefix(diagram, "\n") {
		return nil, errors.New("ayayay")
	}
	rows := strings.Split(strings.Trim(diagram, "\n"), "\n")
	if len(rows) != 2 || len(rows[0]) != len(rows[1]) || len(rows[0])%2 == 1 {
		return nil, errors.New("ayayay")
	}
	for _, row := range rows {
		for _, el := range row {
			if _, ok := seeds[string(el)]; !ok {
				return nil, errors.New("ayayay")
			}
		}
	}

	copied := make([]string, len(children))
    copy(copied, children)

	sort.Strings(copied)
	for i, child := range copied {
		if i < len(copied) - 1 && child == copied[i+1] {
			return nil, errors.New("ayayay")
		}
	}
	return &Garden{rows, children}, nil
}

func (g *Garden) Plants(child string) ([]string, bool) {
	idx := -1
	res := make([]string, 0)
	copied := make([]string, len(g.children))
    copy(copied, g.children)

	for i, chld := range g.children {
		if chld == child {
			idx = i
			break
		}
	}
	if idx == -1 {
		return []string{}, false
	}
	for _, row := range g.rows {
		plant1, _ := seeds[string(row[2*idx])]
		plant2, _ := seeds[string(row[2*idx+1])]
		res = append(res, plant1, plant2)
	}
	return res, true
}
