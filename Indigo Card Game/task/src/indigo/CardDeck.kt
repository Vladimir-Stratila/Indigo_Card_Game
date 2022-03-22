package indigo

object CardDeck {
    private val cards = mutableListOf<Card>()
    init {
        for (s in Card.Suits.values()){
            for (r in Card.Ranks.values()) {
                cards.add(Card(r, s))
            }
        }
    }

    fun reset() {
        cards.clear()
        for (s in Card.Suits.values()){
            for (r in Card.Ranks.values()) {
                cards.add(Card(r, s))
            }
        }
        println("Card deck is reset.")
    }
    fun shuffle() {
        cards.shuffle()
        println("Card deck is shuffled.")
    }
    fun get() {
        println("Number of cards: ")
        try {
            val number = readln().toInt()
            if (number !in 1..52) {
                println("Invalid number of cards.")
            } else if (number > cards.size) {
                println("The remaining cards are insufficient to meet the request.")
            } else {
                println(cards.take(number).joinToString(" "))
                val cardsIterator = cards.iterator()
                for (i in 1..number) {
                    cardsIterator.next()
                    cardsIterator.remove()
                }
            }
        } catch (e: NumberFormatException) {
            println("Invalid number of cards.")
        }
    }
}