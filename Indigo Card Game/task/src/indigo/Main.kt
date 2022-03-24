package indigo

fun main() {
    val table = Table
    val humanPlayer = HumanPlayer()
    val computerPlayer = ComputerPlayer()

    println("Indigo Card Game")

    var action: String
    do {
        println("Play first?")
        action = readln().lowercase()
        when(action) {
            "yes" -> table.currentPlayer = humanPlayer
            "no" -> table.currentPlayer = computerPlayer
        }
    } while (!(action == "yes" || action == "no"))

    table.firstDeal()
    do {
        table.show()
        if (table.pile.size < 52) {
            var playingCard: Card?
            if (table.currentPlayer.hand.size == 0) table.dealCards(6)
            if (table.currentPlayer == humanPlayer) table.currentPlayer.showCards()
            do {
                playingCard = table.currentPlayer.giveCard()
            } while (!(table.currentPlayer.isGameOver || playingCard != null))
            if (playingCard != null) {
                table.pile.add(playingCard)
                if (table.currentPlayer == humanPlayer) table.changePlayer(computerPlayer)
                else table.changePlayer(humanPlayer)
            }
        } else table.currentPlayer.isGameOver = true
    } while (!table.currentPlayer.isGameOver)

    println("Game Over")
}