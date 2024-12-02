package aoc2024.day02

import aoc2024.common.Utils

class Day02 {
    static void main(String[] args) {
        List<String> input = Utils.readFile("inputs/day02-input.txt")
        println("The answer to part one is ${partOne(input)}")
        println("The answer to part two is ${partTwo(input)}")
    }

    static partOne(List<String> input) {
        int safeReports = 0
        input.each {
            List<Integer> levels = it.split(" ").collect { Integer.parseInt(it) }
            levels = levels.first() > levels.last() ? levels.reverse() : levels
            if ((1..<levels.size()).every { 0 < levels[it] - levels[it-1] && levels[it] - levels[it-1] < 4 }) {
                safeReports++
            }
        }
        return safeReports
    }

    static partTwo(List<String> input) {
        int safeReports = 0
        input.each {
            List<Integer> levels = it.split(" ").collect { Integer.parseInt(it) }
            levels = levels.first() > levels.last() ? levels.reverse() : levels
            for (i in levels.size()..0) {
                List<Integer> compareLevels = levels.collect()
                if (i != levels.size()) compareLevels.removeAt(i)
                if ((1..<compareLevels.size()).every { 0 < compareLevels[it] - compareLevels[it-1] && compareLevels[it] - compareLevels[it-1] < 4 }) {
                    safeReports++
                    break
                }
            }
        }
        return safeReports
    }
}
