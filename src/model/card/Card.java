package model.card;

import java.util.ArrayList;
import java.util.Comparator;

public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
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

    public static ArrayList<Card> getAllCards() {
        return cards;
    }

    public static Comparator<Card> nameComparator = Comparator.comparing(card -> card.name);

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Card getCardByName(String name) {
        for (Card card : cards) {
            if (card.getName().equals(name))
                return card;
        }
        return null;
    }

}
