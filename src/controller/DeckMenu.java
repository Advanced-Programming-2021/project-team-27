package controller;

import model.card.Card;
import model.user.Deck;
import model.user.MainDeck;
import model.user.SideDeck;
import model.user.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.menu.MainMenuView;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckMenu {
    private String terminalOutput = "";
    private User currentUser;
    private HashMap<String, Deck> decks;

    public DeckMenu(String currentUserName){
        this.currentUser = User.getUserByUsername(currentUserName);
        decks = currentUser.getDecks();
    }

    public void cardShow(String cardName) {
        Card.showCard(cardName);
    }

    public void createDeck(String deckName) {
        if (decks.containsKey(deckName))
            terminalOutput = "deck with name " + deckName + " already exists";
        else {
            Deck deck = new Deck(deckName, currentUser.getUsername());
            currentUser.addDeck(deckName, deck);
            terminalOutput = "deck created successfully!";
        }
    }

    public void deleteDeck(String deckName) {
        if (!decks.containsKey(deckName))
            terminalOutput = "deck with name " + deckName + " does not exist";
        else {
            currentUser.deleteDeck(deckName);
            terminalOutput = "deck deleted successfully!";
        }
    }

    public void setActive(String deckName) {
        if (!decks.containsKey(deckName))
            terminalOutput = "deck with name " + deckName + " does not exist";
        else {
            Deck deck = Deck.getDeckByName(deckName);
            currentUser.setActiveDeck(deck);
            terminalOutput = "deck activated successfully";
        }
    }

    public void addCardToDeck(String deckName, String cardName, boolean isSideDeck) {
        Card card = Card.getCardByName(cardName);
        ArrayList <Card> cards = currentUser.getCards();
        HashMap<String, Deck> decks = currentUser.getDecks();
        if (!cards.contains(card)){
            terminalOutput = "card with name " + cardName + " does not exist";
            return;
        }
        if (!decks.containsKey(deckName)){
            terminalOutput = "deck with name " + deckName + " does not exist";
            return;
        }
        card = cards.get(cards.indexOf(card));
        Deck deck = decks.get(deckName);
        if  (!isSideDeck && deck.getMainDeck().getMainDeckSize() == 40){
            terminalOutput = "main deck is full";
            return;
        }
        if  (isSideDeck && deck.getSideDeck().getSideDeckSize() == 15){
            terminalOutput = "side deck is full";
            return;
        }
        int countCardsInDeck = 0;
        for (Card card1 : deck.getMainDeck().getMainDeckCards()) {
            if (card1.getName().equals(cardName))
                countCardsInDeck++;
        }
        for (Card card1 : deck.getSideDeck().getSideDeckCards()) {
            if (card1.getName().equals(cardName))
                countCardsInDeck++;
        }
        if (countCardsInDeck == 3){
            terminalOutput = "there are already three cards with name " + cardName + " in deck " + deckName;
            return;
        }
        if (!isSideDeck) {
            deck.getMainDeck().addCard(card);
            if (deck.getMainDeck().getMainDeckSize() >= 40)
                deck.setValid(true);
        }
        if (isSideDeck)
            deck.getSideDeck().addCard(card);
        terminalOutput = "card added to deck successfully";
    }

    public void removeCardFromDeck(String deckName, String cardName, boolean isSideDeck) {
        HashMap<String, Deck> decks = currentUser.getDecks();
        if (!decks.containsKey(deckName)){
            terminalOutput = "deck with name " + deckName + " does not exist";
            return;
        }
        Deck deck = decks.get(deckName);
        if (!isSideDeck) {
            ArrayList <Card> cards = deck.getMainDeck().getMainDeckCards();
            Card wantedCard = null;
            boolean isCardInDeck = false;
            for (Card card : cards){
                if (card.getName().equals(cardName)) {
                    isCardInDeck = true;
                    wantedCard = card;
                }
            }
            if (!isCardInDeck)
                terminalOutput = "card with name " + cardName + " does not exist in main deck";
            else {
                deck.getMainDeck().removeCard(wantedCard);
                if (deck.getMainDeck().getMainDeckSize() < 40)
                    deck.setValid(false);
                terminalOutput = "card removed form deck successfully";
            }
        }
        if (isSideDeck){
            ArrayList <Card> cards = deck.getSideDeck().getSideDeckCards();
            Card wantedCard = null;
            boolean isCardInDeck = false;
            for (Card card : cards){
                if (card.getName().equals(cardName)) {
                    isCardInDeck = true;
                    wantedCard = card;
                }
            }
            if (!isCardInDeck)
                terminalOutput = "card with name " + cardName + " does not exist in side deck";
            else {
                deck.getSideDeck().removeCard(wantedCard);
                terminalOutput = "card removed form deck successfully";
            }
        }
    }

    public void showAllDeck() {
        terminalOutput = "Decks:\nActive deck:\n";
        HashMap<String, Deck> decks = currentUser.getDecks();
        Deck activeDeck = currentUser.getActiveDeck();
        if (activeDeck != null)
            printDeckForAllDeck(activeDeck);
        terminalOutput += "Other decks:\n";
        for (Map.Entry<String, Deck> entry : decks.entrySet()){
            Deck deck = entry.getValue();
            if (!deck.isActiveDeck())
                printDeckForAllDeck(deck);
        }
    }

    private void printDeckForAllDeck(Deck deck){
        terminalOutput += deck.getName() + ": main deck " + deck.getMainDeck().getMainDeckSize() +
                ", side deck " + deck.getSideDeck().getSideDeckSize() + ", ";
        if (deck.isValid())
            terminalOutput += "valid\n";
        else
            terminalOutput += "invalid\n";
    }

    public void showOneDeck(String deckName, boolean isSideDeck) {
        terminalOutput = "Deck: " + deckName + "\n";
        ArrayList <Card> monsters = new ArrayList<>();
        ArrayList <Card> spellsAndTraps = new ArrayList<>();
        ArrayList <Card> cards = new ArrayList<>();
        if (!isSideDeck){
            terminalOutput += "Main deck:\nMonsters:\n";
            MainDeck mainDeck = Deck.getDeckByName(deckName).getMainDeck();
            cards = mainDeck.getMainDeckCards();
        }
        if (isSideDeck){
            terminalOutput += "Side deck:\nMonsters:\n";
            SideDeck sideDeck = Deck.getDeckByName(deckName).getSideDeck();
            cards = sideDeck.getSideDeckCards();
        }
        for (Card card : cards){
            if (card.getType().equals("monster"))
                monsters.add(card);
            else
                spellsAndTraps.add(card);
        }
        monsters.sort(Card.nameComparator);
        spellsAndTraps.sort(Card.nameComparator);
        for (Card card : monsters)
            terminalOutput += card.getName() + ": " + card.getDescription() + "\n";
        terminalOutput += "Spell and Traps:\n";
        for (Card card : spellsAndTraps)
            terminalOutput += card.getName() + ": " + card.getDescription() + "\n";
    }

    public void showAllCards() {
        ArrayList<Card> cards = currentUser.getCards();
        cards.sort(Card.nameComparator);
        for (Card card : cards)
            terminalOutput += card.getName() + ": " + card.getDescription() + "\n";
    }

    public String getTerminalOutput(){
        String returnValue = terminalOutput;
        terminalOutput = "";
        return returnValue;
    }

}
