package twofer

import "fmt"

// ShareWith prints with whom the cookie should be shared.
// If the person is unknown just `you` is used, otherwise person's name
func ShareWith(name string) string {
	if name == "" {
		name = "you"
	}
	return fmt.Sprintf("One for %v, one for me.", name)
}
