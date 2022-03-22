fun main() {
    val setSize = readln().toInt()
    val listOfNumbers = mutableListOf<Int>()
    for (i in 1..setSize) {
        listOfNumbers.add(readln().toInt())
    }
    val findNumber = readln().toInt()
    if (listOfNumbers.contains(findNumber)) println("YES") else println("NO")
}
