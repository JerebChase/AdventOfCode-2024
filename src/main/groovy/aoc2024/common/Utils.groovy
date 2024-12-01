package aoc2024.common

class Utils {
    static List<String> readFile(String path) {
        return this.getResource("/$path").text.split('\n')
    }
}
