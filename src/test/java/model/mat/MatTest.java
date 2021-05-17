package model.mat;

import model.card.Card;
import model.card.Monster;
import model.user.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MatTest {
    private static Mat mat;

    @BeforeAll
    static void init() {
        mat = new Mat();
    }

    @Test
    void setIsChanged() {
        Assertions.assertFalse(mat.isChangedCard(0));
        mat.setIsChanged(true, 0);
        Assertions.assertTrue(mat.isChangedCard(0));
    }

    @Test
    void setHandCard() {
        Card card = new Card();
        Assertions.assertTrue(mat.setHandCard(card));
        Assertions.assertTrue(mat.setHandCard(card));
        Assertions.assertTrue(mat.setHandCard(card));
        Assertions.assertNotSame(card, mat.getHandCard(3));
        Assertions.assertTrue(mat.setHandCard(card));
        Assertions.assertTrue(mat.setHandCard(card));
        Assertions.assertTrue(mat.setHandCard(card));
        Assertions.assertFalse(mat.setHandCard(card));
        Assertions.assertSame(card, mat.getHandCard(5));
    }

    @Test
    void setFieldZone() {
        Card card = new Card();
        mat.setFieldZone(card);
        Assertions.assertSame(card, mat.getFieldZone());
    }

    @Test
    void addCardToGraveyard() {
        Card card = new Card();
        Assertions.assertNotNull(mat.getGraveyard());
        mat.addCardToGraveyard(card);
        Assertions.assertEquals(1, mat.getGraveyard().size());
    }

    @Test
    void setMonsterZone() {
        Assertions.assertNull(mat.getMonsterZone(2));
        Monster monster = new Monster("m", 1, "a", "t", "c", 200, 300, "gei", 1000);
        mat.setMonsterZone(2, monster);
        Assertions.assertSame(monster, mat.getMonsterZone(2));
        Assertions.assertFalse(mat.isMonsterZoneIsFull());
        mat.setMonsterZone(0, monster);
        mat.setMonsterZone(1, monster);
        mat.setMonsterZone(3, monster);
        mat.setMonsterZone(4, monster);
    }

    @Test
    void setSpellAndTrapZone() {
        Assertions.assertNull(mat.getSpellAndTrapZone(2));
        Card card = new Card();
        mat.setSpellAndTrapZone(2, card);
        Assertions.assertSame(card, mat.getSpellAndTrapZone(2));
    }

    @Test
    void isMonsterZoneIsFull() {
        Assertions.assertTrue(mat.isMonsterZoneIsFull());
    }

    @Test
    void isSpellAndTrapZoneIsFull() {
        Assertions.assertFalse(mat.isSpellAndTrapZoneIsFull());
    }

    @Test
    void printMat() {
        Deck deck = new Deck("arad", "arad");
        Assertions.assertNotNull(mat.printMat(deck, true));
        Assertions.assertNotNull(mat.printMat(deck, false));
    }
}