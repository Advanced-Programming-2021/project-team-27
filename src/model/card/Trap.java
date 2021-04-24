package model.card;

import java.util.ArrayList;

public class Trap extends Card{

    protected ArrayList<Trap> allTraps = new ArrayList<>();

    protected String icon;
    protected String status;


    public Trap(String name, String icon, String description, String status, int price) {
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.status = status;
        this.price = price;
        allTraps.add(this);
        Card.addToCards(this);
    }
}
