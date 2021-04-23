package model.card;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards=new ArrayList<>();
    protected String name;
    protected String type;
    protected String description;
    protected String id;
    protected int price;

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Card> getAllCards(){
        return null;
    }


    public static Card getCardByName(String name){
        for (Card card : cards) {
            if (card.getName().equals(name))
                return card;
        }
        return null;
    }

}
