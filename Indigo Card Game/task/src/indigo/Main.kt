package indigo

fun main() {
    val table = Table
    println("Indigo Card Game")
    table.whoIsFirst()
    table.firstDeal()
    do {
        table.show()
        var playingCard: Card?
        var topCard =  if (table.pile.isNotEmpty()) table.pile.last() else null
        if (table.currentPlayer.hand.size == 0 && table.deck.cards.size > 0) table.dealCards(6)
        if (table.currentPlayer.hand.size > 0) {
            table.currentPlayer.showCards()
            do {
                playingCard = table.currentPlayer.giveCard(topCard)
                if (table.currentPlayer.isGameOver) break
            } while (playingCard == null)
            if (playingCard != null) {
                table.pile.add(playingCard)
                table.cardCount++
                table.checkCard()
                table.changePlayer()
            }
            if (table.cardCount == 52) {
                table.currentPlayer.isGameOver = true
                table.show()
                table.takenRemaining.archive.addAll(table.pile)
                table.showFinalScore()
            }
        }
    } while (!table.currentPlayer.isGameOver)
    println("Game Over")
}