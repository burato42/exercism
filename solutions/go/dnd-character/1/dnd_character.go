package dndcharacter

import (
	"math"
	"math/rand"
)

type Character struct {
	Strength     int
	Dexterity    int
	Constitution int
	Intelligence int
	Wisdom       int
	Charisma     int
	Hitpoints    int
}

// Modifier calculates the ability modifier for a given ability score
func Modifier(score int) int {
	return int(math.Floor(float64(score-10) / 2))
}

// Ability uses randomness to generate the score for an ability
func Ability() int {
	min, res := 6, 0
	for i := 0; i < 4; i++ {
		throw := rand.Intn(6) + 1
		if throw <= min {
			min = throw
		}
		res += throw
	}
	return res - min
}

// GenerateCharacter creates a new Character with random scores for abilities
func GenerateCharacter() Character {
	strength := Ability()
	dexterity := Ability()
	constitution := Ability()
	intelligence := Ability()
	wisdom := Ability()
	charisma := Ability()
	hitpoints := 10 + Modifier(constitution)
	character := Character{
		strength,
		dexterity,
		constitution,
		intelligence,
		wisdom,
		charisma,
		hitpoints,
	}
	return character
}
