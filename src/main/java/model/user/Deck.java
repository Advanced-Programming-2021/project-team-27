package model.user;

import java.util.ArrayList;

public class Deck {
    private static ArrayList<Deck> allDecks = new ArrayList<>();
    private String name;
    private String creatorUsername;
    private MainDeck mainDeck;
    private SideDeck sideDeck;
    private boolean activeDeck;
    private boolean isValid = false;

    public Deck(String name, String creatorUsername){
        this.name = name;
        this.creatorUsername = creatorUsername;
        allDecks.add(this);
    }

    public String getName() {
        return name;
    }

    public MainDeck getMainDeck() {
        return mainDeck;
    }

    public SideDeck getSideDeck() {
        return sideDeck;
    }

    public void setActiveDeck(boolean activeDeck) {
        this.activeDeck = activeDeck;
    }

    public int getSideDeckSize(){
        return sideDeck.getSideDeckSize();
    }

    public int getMainDeckSize(){
        return mainDeck.getMainDeckSize();
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isActiveDeck(){
        return activeDeck;
    }


    public static Deck getDeckByName(String name){
        for (Deck deck : allDecks){
            if (deck.getName().equals(name))
                return deck;
        }
        return null;
    }
}
