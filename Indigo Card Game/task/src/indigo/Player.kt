package indigo

open class Player() {
    val hand = mutableListOf<Card>()
    val archive = mutableListOf<Card>()
    var points: Int = 0
    var isGameOver: Boolean = false
    open fun giveCard(topCard: Card?): Card? {
        val card = hand[0]
        hand.removeAt(0)
        return card
    }
    open fun showCards() {}
    fun countPoints() {
        var result = 0
        for (c in archive) {
            result += c.getPoint()
        }
        points = result
    }
}

class ComputerPlayer() : Player() {
    override fun giveCard(topCard: Card?): Card? {
        // super.giveCard(topCard)
        var card: Card? = null
        val candidatesCards = mutableListOf<Card>()
        var groupBySuits = hand.groupBy { it.cardSuit.suit }.filter { it.value.size > 1 }
        var groupByRanks = hand.groupBy { it.cardRank.rank }.filter { it.value.size > 1 }
        if (hand.size == 1) { // 1) +
            card = hand[0]
        } else {
            if (topCard == null) { // 3) +
                card = if (groupBySuits.isNotEmpty()) groupBySuits.values.random().random()
                else if (groupByRanks.isNotEmpty()) groupByRanks.values.random().random()
                else hand.random()
            }
            else {
                hand.forEach { if (topCard.isAlike(it)) candidatesCards.add(it) }
                if (candidatesCards.size == 0) { // 4) +
                    card = if (groupBySuits.isNotEmpty()) groupBySuits.values.random().random()
                    else if (groupByRanks.isNotEmpty()) groupByRanks.values.random().random()
                    else hand.random()
                }
                if (candidatesCards.size == 1) card = candidatesCards[0] // 2) +
                if (candidatesCards.size >= 2) { // 5)
                    groupBySuits = candidatesCards.groupBy { it.cardSuit.suit }.filter { it.value.size > 1 }
                    groupByRanks = candidatesCards.groupBy { it.cardRank.rank }.filter { it.value.size > 1 }
                    card = if (groupBySuits.isNotEmpty()) groupBySuits.values.random().random()
                    else if (groupByRanks.isNotEmpty()) groupByRanks.values.random().random()
                    else candidatesCards.random()
                }
            }
        }
        hand.remove(card)
        println("Computer plays $card")
        return card
    }
    override fun showCards() {
        println(hand.toString().trim('[',']').filterNot { it == ',' })
    }
}

class HumanPlayer() : Player() {
    override fun giveCard(topCard: Card?): Card? {
        println("Choose a card to play (1-${hand.size}):")
        val input = readln()
        if (input == "exit") isGameOver = true
        return if (isNumber(input) && input.toInt() in (1..hand.size)) {
            val card = hand[input.toInt() - 1]
            hand.removeAt(input.toInt() - 1)
            card
        } else null
    }
    override fun showCards() {
        print("Cards in hand:")
        for (i in hand.indices) {
            print(" ${i+1})${hand[i]}")
        }
        print("\n")
    }
    private fun isNumber(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (ex: NumberFormatException) {
            false
        }
    }
}