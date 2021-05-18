package model.card;

import java.util.ArrayList;

public class Trap extends Card{

    protected static ArrayList<Trap> allTraps = new ArrayList<>();

    protected String icon;
    protected String status;


    public Trap(String name, String icon, String description, String status, int price) {
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.status = status;
        this.price = price;
        this.cardType = "Trap";
        allTraps.add(this);
        Card.addToCards(this);
    }

    public String getIcon() {
        return icon;
    }

    public String getStatus() {
        return status;
    }

    public static Trap getTrapByName(String name) {
        for (Trap trap : allTraps) {
            if (trap.name.equals(name)){
                return trap;
            }
        }
        return null;
    }
}
