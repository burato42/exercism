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
	return greeter.Greet(visitorName)
}

type Italian struct {
	lang string
}

func (italian Italian) LanguageName() string {
	return italian.lang
}

func (italian Italian) Greet(name string) string {
	return fmt.Sprintf("I can speak Italian: Ciao %v!", name)
} 

type Portuguese struct {
	lang string
}

func (port Portuguese) LanguageName() string {
	return port.lang
}

func (port Portuguese) Greet(name string) string {
	return fmt.Sprintf("I can speak Portuguese: Olá %v!", name)
}