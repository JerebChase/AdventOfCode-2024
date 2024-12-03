package aoc2024.day01

import aoc2024.common.Utils

class Day01 {
    static void main(String[] args) {
        def input = Utils.readFile("inputs/day01-input.txt")
        println("The answer to part one is ${partOne(input)}")
        println("The answer to part two is ${partTwo(input)}")
    }

    static partOne(List<String> input) {
        def firstList = input.collect { it.split("   ")[0] }.sort()
        def secondList = input.collect { it.split("   ")[1] }.sort()

        def differences = [firstList, secondList].transpose().collect {
            Math.abs(Integer.parseInt(it[0]) - Integer.parseInt(it[1]))
        }

        differences.sum()
    }

    static partTwo(List<String> input) {
        def leftList = input.collect { it.split("   ")[0] }
        def rightList = input.collect { it.split("   ")[1] }

        def similarity = leftList.collect {
            Integer.parseInt(it) * rightList.count(it)
        }

        similarity.sum()
    }
}
