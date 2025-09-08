package lasagna

// TODO: define the 'PreparationTime()' function
func PreparationTime(layers []string, time int) int {
	if time == 0 {
		time = 2
	}
	return len(layers) * time
}

// TODO: define the 'Quantities()' function
func Quantities(layers []string) (int, float64) {
	noodles := 0
	var sauce float64 = 0.0
	for _, component := range layers {
		if component == "noodles" {
			noodles += 50
		} else if component == "sauce" {
			sauce += 0.2
		}
	}
	return noodles, sauce
}

// TODO: define the 'AddSecretIngredient()' function
func AddSecretIngredient(friendLists []string, myList []string) {
	secretInd := len(friendLists) - 1
	secret := friendLists[secretInd]
	myLastInd := len(myList) - 1
	myList[myLastInd] = secret
	
}

// TODO: define the 'ScaleRecipe()' function
func ScaleRecipe(quantities []float64, scale int) []float64 {
	newQnt := make([]float64, len(quantities))
	for i := 0; i < len(quantities); i++ {
		newQnt[i] = quantities[i] * (float64(scale) / 2.0)
	}
	return newQnt
} 

// Your first steps could be to read through the tasks, and create
// these functions with their correct parameter lists and return types.
// The function body only needs to contain `panic("")`.
// 
// This will make the tests compile, but they will fail.
// You can then implement the function logic one by one and see
// an increasing number of tests passing as you implement more 
// functionality.
