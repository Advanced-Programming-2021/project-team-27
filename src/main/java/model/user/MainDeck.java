package model.user;

import model.card.Card;

import java.util.ArrayList;

public class MainDeck {
    private ArrayList<Card> mainDeckCards;

    public ArrayList<Card> getMainDeckCards() {
        return mainDeckCards;
    }

    public int getMainDeckSize(){
        return mainDeckCards.size();
    }

    public ArrayList<Card> sortDeckCardByName(){
        return mainDeckCards;
    }

    public void addCard(Card card){
        mainDeckCards.add(card);
    }

    public void removeCard(Card card){
        mainDeckCards.remove(card);
    }

    public String toStringsSpellAndTrap(){
        return "mame";
    }

    public String toStringMonsters() {
        return "do";
    }
}
