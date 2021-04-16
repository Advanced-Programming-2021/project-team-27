package model.user;

import model.card.Card;

import java.util.ArrayList;

public class MainDeck {
    private ArrayList<Card> mainDeckCards;



    public int getMainDeckSize(){
        return mainDeckCards.size();
    }

    public ArrayList<Card> sortDeckCardByName(){
        return mainDeckCards;
    }


    public String toStringsSpellAndTrap(){
        return "mame";
    }

    public String toStringMonsters() {
        return "do";
    }
}
