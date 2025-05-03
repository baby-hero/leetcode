package main

import "fmt"

func permuteUnique(nums []int) [][]int {
	size := len(nums)
	frequencies := make(map[int]int)
	for _, num := range nums {
		frequencies[num]++
	}

	var result [][]int

	var backtrack func(permutation []int)
	backtrack = func(permutation []int) {
		if len(permutation) == size {
			permCopy := make([]int, len(permutation))
			copy(permCopy, permutation)
			result = append(result, permCopy)
			return
		}
		for num, freq := range frequencies {
			if freq > 0 {
				frequencies[num]--
				newPerm := append(permutation, num)
				backtrack(newPerm)
				frequencies[num]++
			}
		}
	}
	backtrack(nil)
	return result
}

func main() {
	nums := []int{1, 1, 2}
	results := permuteUnique(nums)
	for _, result := range results {
		for _, num := range result {
			fmt.Print(num, " ")
		}
		fmt.Println()
	}
}
