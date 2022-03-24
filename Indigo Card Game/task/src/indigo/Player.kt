package indigo

open class Player() {
    val hand = mutableListOf<Card>()
    val archive = mutableListOf<Card>()
    var points: Int = 0
    var isGameOver: Boolean = false
    open fun giveCard(): Card? {
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
    override fun giveCard(): Card? {
        val card = super.giveCard()
        println("Computer plays $card")
        return card
    }
}

class HumanPlayer() : Player() {
    override fun giveCard(): Card? {
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