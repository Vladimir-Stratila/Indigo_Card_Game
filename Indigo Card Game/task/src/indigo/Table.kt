package indigo

object Table {
    private val humanPlayer = HumanPlayer()
    private val computerPlayer = ComputerPlayer()
    lateinit var firstPlayer: Player
    lateinit var currentPlayer: Player
    lateinit var takenRemaining: Player
    val pile = mutableListOf<Card>()
    val deck = CardDeck
    var cardCount = 0

    fun whoIsFirst() {
        var action: String
        do {
            println("Play first?")
            action = readln().lowercase()
            when(action) {
                "yes" -> {
                    firstPlayer = humanPlayer
                    currentPlayer = humanPlayer
                    takenRemaining = humanPlayer
                }
                "no" -> {
                    firstPlayer = computerPlayer
                    currentPlayer = computerPlayer
                    takenRemaining = computerPlayer
                }
            }
        } while (!(action == "yes" || action == "no"))
    }
    fun firstDeal() {
        pile.addAll(deck.get(4))
        cardCount += 4
        println("Initial cards on the table: ${pile.joinToString(" ")}")
    }
    fun show() {
        if (pile.size > 0)
            println("\n${pile.size} cards on the table, and the top card is ${pile[pile.size - 1]}")
        else
            println("\nNo cards on the table")
    }
    fun changePlayer() {
        currentPlayer = if (currentPlayer == humanPlayer) computerPlayer else humanPlayer
    }
    fun dealCards(number: Int) {
        currentPlayer.hand.addAll(deck.get(number))
    }
    fun checkCard() {
        if (pile.size > 1 && pile[pile.size - 1].isAlike(pile[pile.size - 2])) {
            currentPlayer.archive.addAll(pile)
            pile.clear()
            takenRemaining = currentPlayer
            when(currentPlayer) {
                humanPlayer -> println("Player wins cards")
                computerPlayer -> println("Computer wins cards")
            }
            currentPlayer.countPoints()
            showScore()
        }
    }
    private fun showScore() {
        println("Score: Player ${humanPlayer.points} - Computer ${computerPlayer.points}")
        println("Cards: Player ${humanPlayer.archive.size} - Computer ${computerPlayer.archive.size}")
    }
    fun showFinalScore() {
        humanPlayer.countPoints()
        computerPlayer.countPoints()
        if (humanPlayer.archive.size > computerPlayer.archive.size) humanPlayer.points += 3 else computerPlayer.points += 3
        if (humanPlayer.archive.size == computerPlayer.archive.size) firstPlayer.points += 3
        showScore()
    }
}