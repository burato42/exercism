package airportrobot

import "fmt"

// Write your code here.
// This exercise does not have tests for each individual task.
// Try to solve all the tasks first before running the tests.
type Greeter interface {
	LanguageName() string
	Greet(name string) string
}

func SayHello(visitorName string, greeter Greeter) string {
	return fmt.Sprintf("I can speak %s: %s", greeter.LanguageName(), greeter.Greet(visitorName))
}

type Italian struct {}

func (italian Italian) LanguageName() string {
	return "Italian"
}

func (italian Italian) Greet(name string) string {
	return fmt.Sprintf("Ciao %v!", name)
} 


type Portuguese struct {}

func (port Portuguese) LanguageName() string {
	return "Portuguese"
}

func (port Portuguese) Greet(name string) string {
	return fmt.Sprintf("Olá %v!", name)
}