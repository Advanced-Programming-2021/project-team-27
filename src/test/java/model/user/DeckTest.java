package model.user;

import model.card.Card;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void getName() {
        Deck deck = new Deck("molaee", "toolabi");
        assertEquals("molaee", deck.getName());
    }

    @Test
    void getMainDeck() {
        Deck deck = new Deck("molaee", "toolabi");
        assertNotNull(deck.getMainDeck());
    }

    @Test
    void getSideDeck() {
        Deck deck = new Deck("molaee", "toolabi");
        assertNotNull(deck.getSideDeck());
    }

    @Test
    void setActiveDeck() {
        Deck deck = new Deck("molaee", "toolabi");
        deck.setActiveDeck(true);
        assertTrue(deck.isActiveDeck());
    }

    @Test
    void getSideDeckSize() {
        Deck deck = new Deck("molaee", "toolabi");
        assertEquals(0, deck.getSideDeckSize());
    }

    @Test
    void getMainDeckSize() {
        Deck deck = new Deck("molaee", "toolabi");
        Card card = new Card();
        deck.getMainDeck().addCard(card);
        assertEquals(1, deck.getMainDeckSize());
    }

    @Test
    void isValid() {
        Deck deck = new Deck("molaee", "toolabi");
        assertFalse(deck.isValid());
    }

    @Test
    void setValid() {
        Deck deck = new Deck("molaee", "toolabi");
        deck.setValid(true);
        assertTrue(deck.isValid());
        deck.setValid(false);
        assertFalse(deck.isValid());
    }

    @Test
    void isActiveDeck() {
        Deck deck = new Deck("molaee", "toolabi");
        assertFalse(deck.isActiveDeck());
    }

    @Test
    void getDeckByName() {
        Deck deck = new Deck("molaee", "toolabii");
        deck.getMainDeck().addCard(new Card());
        assertEquals(1, Deck.getDeckByName("molaee", "toolabii").getMainDeckSize());
        assertSame(deck, Deck.getDeckByName("molaee", "toolabii"));
        assertNull(Deck.getDeckByName("mioo", "jjj"));
    }
}