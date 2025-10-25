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

func mapWorker(dataChunk string, resultsCh chan<- FreqMap, wg *sync.WaitGroup) {
    defer wg.Done()
    resultsCh <- Frequency(dataChunk)  
}

func reduce(finalMap FreqMap, resultsCh <-chan FreqMap, wg *sync.WaitGroup) {
	defer wg.Done()

	for localMap := range resultsCh {
		for key, count := range localMap {
			finalMap[key] += count
		}
	}
}

// ConcurrentFrequency counts the frequency of each rune in the given strings,
// by making use of concurrency.
func ConcurrentFrequency(texts []string) FreqMap {
	numWorkers := len(texts)
    
    var mapperWg sync.WaitGroup
	var reducerWg sync.WaitGroup
    resultsCh := make(chan FreqMap, numWorkers)
    finalMap := make(FreqMap)
    
	reducerWg.Add(1)
    go reduce(finalMap, resultsCh, &reducerWg)
       
	for i := 0; i < numWorkers; i++ {
		mapperWg.Add(1)
		go mapWorker(texts[i], resultsCh, &mapperWg)
	}
    
    mapperWg.Wait()
    
    close(resultsCh)
	reducerWg.Wait()
    
    return finalMap
}
