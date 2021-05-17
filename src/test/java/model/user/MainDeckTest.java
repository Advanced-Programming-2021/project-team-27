package model.user;

import model.card.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainDeckTest {

    @Test
    void getMainDeckSize() {
        Card c1 = new Card();
        Card c2 = new Card();
        MainDeck mainDeck = new MainDeck();
        mainDeck.addCard(c1);
        mainDeck.addCard(c2);
        Assertions.assertEquals(2, mainDeck.getMainDeckSize());
    }

    @Test
    void addCard() {
        Card c1 = new Card();
        Card c2 = new Card();
        MainDeck mainDeck = new MainDeck();
        mainDeck.addCard(c1);
        mainDeck.addCard(c2);
        ArrayList<Card> mainDeckCards = mainDeck.getMainDeckCards();
        Assertions.assertEquals(c1, mainDeckCards.get(0));
    }

    @Test
    void removeCard() {
        Card c1 = new Card();
        Card c2 = new Card();
        MainDeck mainDeck = new MainDeck();
        mainDeck.addCard(c1);
        mainDeck.addCard(c2);
        mainDeck.removeCard(c1);
        ArrayList<Card> mainDeckCards = mainDeck.getMainDeckCards();
        Assertions.assertEquals(c2, mainDeckCards.get(0));
    }
}