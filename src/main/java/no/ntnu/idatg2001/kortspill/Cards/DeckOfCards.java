package no.ntnu.idatg2001.kortspill.Cards;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class which represents a deck of cards.
 * Contains an arrayList of 52 cards.
 */
public class DeckOfCards {
    private ArrayList<PlayingCards> deckOfCards;
    private int face;

    /**
     * Constructor which creates 52 playingCard objects.
     */
    public DeckOfCards() {
        deckOfCards = new ArrayList<>();
        face = 1;

        while(deckOfCards.size() != 52) {
            if (deckOfCards.stream().filter(c -> c.getSuit() == 'S').count() != 13) {
                PlayingCards S = new PlayingCards('S', face);
                deckOfCards.add(S);
            }
            if (deckOfCards.stream().filter(c -> c.getSuit() == 'H').count() != 13) {
                PlayingCards H = new PlayingCards('H', face);
                deckOfCards.add(H);
            }
            if (deckOfCards.stream().filter(c -> c.getSuit() == 'D').count() != 13) {
                PlayingCards D = new PlayingCards('D', face);
                deckOfCards.add(D);
            }
            if (deckOfCards.stream().filter(c -> c.getSuit() == 'C').count() != 13) {
                PlayingCards C = new PlayingCards('C', face);
                deckOfCards.add(C);
            }
            face++;
        }
    }

    /**
     * Method which deals random cards from deck.
     * @param n Integer of amount of cards wanted.
     * @return Arraylist of playingCards, I.E. a hand.
     */
    protected ArrayList<PlayingCards> dealHand(int n) {
        ArrayList<PlayingCards> handOfCards = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            handOfCards.add(
                deckOfCards.get(r.nextInt( 52)));
        }
        return handOfCards;
    }

    public ArrayList<PlayingCards> getDeckOfCards() {
        return deckOfCards;
    }
}
