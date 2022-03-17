package no.ntnu.idatg2001.kortspill.Cards;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author Sandeth
 * @version 2020-01-10
 */
public class PlayingCards {
    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final int face; // a number between 1 and 13

    /**
     * Creates an instance of a PlayingCard with a given suit and face.
     *
     * @param suit The suit of the card, as a single character. 'S' for Spades,
     *             'H' for Heart, 'D' for Diamonds and 'C' for clubs
     * @param face The face value of the card, an integer between 1 and 13
     */
    public PlayingCards(char suit, int face) throws IllegalArgumentException {
        if (suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C')
            this.suit = suit;
        else
            throw new IllegalArgumentException("Invalid suit!");
        if (face <= 13 && face >= 1)
            this.face = face;
        else
            throw new IllegalArgumentException("Invalid face!");
    }

    /**
     * Returns the face of the card (value between 1 and 13).
     *
     * @return the face of the card
     */
    public int getFace() {
        return face;
    }

    /**
     * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for Clubs
     *
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }

    public String getPngValue() {
        return (Character.toString(suit) + face + ".png");
    }

    /**
     * Returns the suit and face of the card as a string.
     * A 4 of hearts is returned as the string "H4".
     *
     * @return the suit and face of the card as a string
     */
    @Override
    public String toString() {
        return String.format("%s%s", suit, face);
    }
}
