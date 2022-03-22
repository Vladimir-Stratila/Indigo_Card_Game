package indigo

fun main() {
    var action: String
    do {
        println("Choose an action (reset, shuffle, get, exit):")
        action = readln()
        when(action) {
            "reset" -> CardDeck.reset()
            "shuffle" -> CardDeck.shuffle()
            "get" -> CardDeck.get()
            "exit" -> {}
            else -> println("Wrong action.")
        }
    } while (action != "exit")
    println("Bye")
}