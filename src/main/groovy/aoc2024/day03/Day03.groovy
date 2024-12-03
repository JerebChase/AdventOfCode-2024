package aoc2024.day03

import aoc2024.common.Utils

class Day03 {
    static void main(String[] args) {
        def input = Utils.readFile("inputs/day03-input.txt")
        println("The answer to part one is ${partOne(input)}")
        println("The answer to part two is ${partTwo(input)}")
    }

    static partOne(List<String> input) {
        return (input.join() =~ /mul\(\d+,\d+\)/).collect {
            def numbers = (it =~ /\d+/).collect { Integer.parseInt(it) }
            numbers.first() * numbers.last()
        }.sum()
    }

    static partTwo(List<String> input) {
        def matches = (input.join() =~ /mul\(\d+,\d+\)|do\(\)|don't\(\)/).collect()
        def multiply = true
        def sum = 0
        for (item in matches) {
            if (item == "don't()") { multiply = false }
            else if (item == "do()") { multiply = true }
            else {
                if (multiply) {
                    def numbers = (item =~ /\d+/).collect { Integer.parseInt(it) }
                    sum += numbers.first() * numbers.last()
                }
            }
        }
        return sum
    }
}
