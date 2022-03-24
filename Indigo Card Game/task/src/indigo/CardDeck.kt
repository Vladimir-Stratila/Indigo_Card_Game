package indigo

object CardDeck {
    private val cards = mutableListOf<Card>()
    init {
        reset()
        shuffle()
    }
    private fun reset() {
        cards.clear()
        for (s in Card.Suits.values()){
            for (r in Card.Ranks.values()) {
                cards.add(Card(r, s))
            }
        }
    }

    private fun shuffle() {
        cards.shuffle()
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
    fun get(number: Int): List<Card> {
        val deal = cards.take(number)
        val cardsIterator = cards.iterator()
        for (i in 1..number) {
            cardsIterator.next()
            cardsIterator.remove()
        }
        return deal
    }
}