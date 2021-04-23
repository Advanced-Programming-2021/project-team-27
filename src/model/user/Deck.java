package model.user;

public class Deck {
    private String name;
    private String creatorUsername;
    private MainDeck mainDeck;
    private SideDeck sideDeck;
    private boolean activeDeck;

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


    public boolean isActiveDeck(){
        return activeDeck;
    }



}
