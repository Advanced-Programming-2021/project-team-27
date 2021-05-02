package model.card;

import java.util.ArrayList;

public class Spell extends Card{

    protected ArrayList<Spell> allSpells = new ArrayList<>();

    protected String icon;
    protected String status;


    public Spell(String name, String icon, String description, String status, int price) {
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.status = status;
        this.price = price;
        allSpells.add(this);
        Card.addToCards(this);
    }


}
