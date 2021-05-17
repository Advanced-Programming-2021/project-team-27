package model.user;

import model.card.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SideDeckTest {

    @Test
    void getSideDeckSize() {
        Card c1 = new Card();
        Card c2 = new Card();
        SideDeck sideDeck = new SideDeck();
        sideDeck.addCard(c1);
        sideDeck.addCard(c2);
        Assertions.assertEquals(2, sideDeck.getSideDeckSize());
    }

    @Test
    void addCard() {
        Card c1 = new Card();
        Card c2 = new Card();
        SideDeck sideDeck = new SideDeck();
        sideDeck.addCard(c1);
        sideDeck.addCard(c2);
        ArrayList<Card> sideDeckCards = sideDeck.getSideDeckCards();
        Assertions.assertEquals(c1, sideDeckCards.get(0));
    }

    @Test
    void removeCard() {
        Card c1 = new Card();
        Card c2 = new Card();
        SideDeck sideDeck = new SideDeck();
        sideDeck.addCard(c1);
        sideDeck.addCard(c2);
        sideDeck.removeCard(c1);
        ArrayList<Card> sideDeckCards = sideDeck.getSideDeckCards();
        Assertions.assertEquals(c2, sideDeckCards.get(0));
    }
}