package letter

import "sync"

// FreqMap records the frequency of each rune in a given text.
type FreqMap map[rune]int

// Frequency counts the frequency of each rune in a given text and returns this
// data as a FreqMap.
func Frequency(text string) FreqMap {
	frequencies := FreqMap{}
	for _, r := range text {
		frequencies[r]++
	}
	return frequencies
}

// ConcurrentFrequency counts the frequency of each rune in the given strings,
// by making use of concurrency.
func ConcurrentFrequency(strings []string) FreqMap {
    numWorkers := len(strings)
    results := make(chan FreqMap, numWorkers)
    var wg sync.WaitGroup

    for _, text := range strings {
        wg.Add(1)
        go func(t string) {
            defer wg.Done()
            results <- Frequency(t)
        }(text)
    }

    wg.Wait()
    close(results)

    finalMap := make(FreqMap)
    for freq := range results {
        for k, v := range freq {
            finalMap[k] += v
        }
    }
    return finalMap
}