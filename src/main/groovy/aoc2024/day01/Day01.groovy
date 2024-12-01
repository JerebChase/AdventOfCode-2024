package aoc2024.day01

import aoc2024.common.Utils

class Day01 {
    static void main(String[] args) {
        List<String> input = Utils.readFile("inputs/day01-input.txt")
        println("The answer to part one is ${partOne(input)}")
        println("The answer to part two is ${partTwo(input)}")
    }

    static partOne(List<String> input) {
        List<String> firstList = input.collect { it.split("   ")[0] }.sort()
        List<String> secondList = input.collect { it.split("   ")[1] }.sort()

        List<Integer> differences = [firstList, secondList].transpose().collect {
            Math.abs(Integer.parseInt(it[0]) - Integer.parseInt(it[1]))
        }

        differences.sum()
    }

    static partTwo(List<String> input) {
        List<String> leftList = input.collect { it.split("   ")[0] }
        List<String> rightList = input.collect { it.split("   ")[1] }

        List<Integer> similarity = leftList.collect {
            Integer.parseInt(it) * rightList.count(it)
        }

        similarity.sum()
    }
}
