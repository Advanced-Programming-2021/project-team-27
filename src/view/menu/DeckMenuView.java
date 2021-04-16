package view.menu;

import controller.ShopMenu;

import java.util.regex.Matcher;

public class DeckMenuView {

    public void deckMenuRun(){
        String input;
    }

    public void cardShow(String input){
        ShopMenu shopMenu=new ShopMenu();
        System.out.println(shopMenu.cardShow("ko"));

    }

    public void createDeck(String input){
        String deckName;
        Matcher matcher;
    }

    public void deleteDeck(String input){
        String deckName;
        Matcher matcher;
    }

    public void setActive(String input){
        String deckName;
        Matcher matcher;
    }

    public void addCardToDeck(String input){
        String deckName;
        String cardName;
        boolean isSideDeck;
        Matcher matcher;
    }

    public void removeCardFromDeck(String input){
        String deckName;
        String cardName;
        boolean isSideDeck;
        Matcher matcher;
    }

    public void showAllDeck(String input){

    }

    public void showOneDeck(String input){
        String deckName;
        boolean isSideDeck;
        Matcher matcher;
    }
    public void showAllCards(String input){

    }
}
