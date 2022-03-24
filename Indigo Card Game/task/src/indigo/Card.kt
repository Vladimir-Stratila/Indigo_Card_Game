package indigo

data class Card(private val cardRank: Ranks, private val cardSuit: Suits) {
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
}