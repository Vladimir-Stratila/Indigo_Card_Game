package indigo

data class Card(val cardRank: Ranks, val cardSuit: Suits) {
    enum class Ranks(val rank: String) {
        ACE("A"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K"),
    }
    enum class Suits(val suit: Char) {
        DIAMONDS('♦'),
        HEART('♥'),
        SPADES('♠'),
        CLUBS('♣')
    }
    override fun toString(): String {
        return "${cardRank.rank}${cardSuit.suit}"
    }
    fun isAlike(card: Card): Boolean {
        return (card.cardRank == this.cardRank || card.cardSuit == this.cardSuit)
    }
    fun getPoint(): Int {
        return when (cardRank.rank) {
            "A" -> 1
            "10" -> 1
            "J" -> 1
            "Q" -> 1
            "K" -> 1
            else -> 0
        }
    }
}