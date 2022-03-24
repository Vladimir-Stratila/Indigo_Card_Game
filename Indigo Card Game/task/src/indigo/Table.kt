package indigo

object Table {
    lateinit var currentPlayer: Player
    val pile = mutableListOf<Card>()
    private val deck = CardDeck
    fun firstDeal() {
        pile.addAll(deck.get(4))
        println("Initial cards on the table: ${pile.joinToString(" ")}")
    }
    fun show() {
        println("\n${pile.size} cards on the table, and the top card is ${pile[pile.size - 1]}")
    }
    fun changePlayer(player: Player) {
        currentPlayer = player
    }
    fun dealCards(number: Int) {
        currentPlayer.hand.addAll(deck.get(number))
    }
}