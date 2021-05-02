package model.card;

import java.util.ArrayList;

public class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    protected String name;
    protected String cardType;
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
        return null;
    }


    public static Card getCardByName(String name) {
        for (Card card : cards) {
            if (card.getName().equals(name))
                return card;
        }
        return null;
    }

    public static String showCard(String name) {
        String cardInfo = "Name : ";
        Card card = getCardByName(name);
        assert card != null;
        if (card.cardType.equals("Spell")) {
            Spell spell = Spell.getSpellByName(name);
            cardInfo += spell.getName() + "\n" + "Spell" + "\n";
            cardInfo += "Type : " + spell.icon + "\n";
            cardInfo += "Description : " + spell.getDescription() + "\n";
        } else if (card.cardType.equals("Trap")){
            Trap trap = Trap.getTrapByName(name);
            cardInfo += trap.getName() + "\n" + "Trap" + "\n";
            cardInfo += "Type : " + trap.icon + "\n";
            cardInfo += "Description : " + trap.getDescription() + "\n";
        } else {
            Monster monster = Monster.getMonsterByName(name);
            cardInfo += monster.getName() + "\n";
            cardInfo += "Level : " + monster.level + "\n";
            cardInfo += "Type : " + monster.monsterType + "\n";
            cardInfo += "ATK : " + monster.attack + "\n";
            cardInfo += "DEF : " + monster.defence + "\n";
            cardInfo += "Description : " + monster.getDescription() + "\n";
        }
        return cardInfo;
    }

    public static void addToCards(Card card) {
        cards.add(card);
    }

}
