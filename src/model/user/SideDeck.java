package model.user;

import model.card.Card;

import java.util.ArrayList;

public class SideDeck {
    private ArrayList<Card> sideDeckCards;

    public int getSideDeckSize(){
        return sideDeckCards.size();
    }

    public ArrayList<Card> sortDeckCardByName() {
        return sideDeckCards;
    }


    public String toStringsSpellAndTrap(){
        return "mame";
    }

    public String toStringMonsters() {
        return "do";
    }
}
