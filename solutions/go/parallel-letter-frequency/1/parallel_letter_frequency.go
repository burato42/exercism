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

func mapWorker(dataChunk []string, resultsCh chan<- FreqMap, wg *sync.WaitGroup) {
    defer wg.Done()
    
    for _, item := range dataChunk {
        resultsCh <- Frequency(item)
    }   
}

func reduce(finalMap FreqMap, resultsCh <-chan FreqMap, numWorkers int) {
    for i := 0; i < numWorkers; i++ {
        localMap := <-resultsCh

        for key, count := range localMap {
            finalMap[key] += count
        }
    }
}

// ConcurrentFrequency counts the frequency of each rune in the given strings,
// by making use of concurrency.
func ConcurrentFrequency(texts []string) FreqMap {
	numWorkers := len(texts)
    
    var wg sync.WaitGroup
    resultsCh := make(chan FreqMap, numWorkers)
    finalMap := make(FreqMap)
    
    go reduce(finalMap, resultsCh, numWorkers)
    
    chunkSize := (len(texts) + numWorkers - 1) / numWorkers
    
    for i := 0; i < numWorkers; i++ {
        start := i * chunkSize
        end := (i + 1) * chunkSize
        if end > len(texts) {
            end = len(texts)
        }
        
        if start < len(texts) {
            wg.Add(1)
            dataChunk := texts[start:end]
            go mapWorker(dataChunk, resultsCh, &wg)
        }
    }
    
    wg.Wait()
    
    close(resultsCh) 
    
    return finalMap
}
