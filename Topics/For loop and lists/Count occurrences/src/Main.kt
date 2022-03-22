fun main() {
    val numbers = mutableListOf<Int>()
    val listSize = readln().toInt()
    for (i in 1..listSize) {
        numbers.add(readln().toInt())
    }
    val findNumber = readln().toInt()
    val findCount = numbers.count { it == findNumber }
    /*var times = 0
    for (i in 0..listSize - 1) {
        if (findNumber == numbers[i]) times++
    }
    println(times)*/
    println(findCount)
}
