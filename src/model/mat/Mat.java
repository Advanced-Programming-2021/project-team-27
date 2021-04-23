package model.mat;

import model.card.Card;
import model.card.Monster;

import java.util.ArrayList;

public class Mat {
    private ArrayList<Card> graveyard;
    private Monster[] monsterZone = new Monster[5];
    private Card[] spellAndTrapZone = new Card[5];
    private Card fieldZone;

    public void setFieldZone(Card fieldZone) {
        this.fieldZone = fieldZone;
    }

    public void setGraveyard(ArrayList<Card> graveyard) {
        this.graveyard = graveyard;
    }

    public void setMonsterZone(Monster[] monsterZone) {
        this.monsterZone = monsterZone;
    }

    public void setSpellAndTrapZone(Card[] spellAndTrapZone) {
        this.spellAndTrapZone = spellAndTrapZone;
    }

    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }

    public Card getFieldZone() {
        return fieldZone;
    }

    public Card[] getSpellAndTrapZone() {
        return spellAndTrapZone;
    }

    public Monster[] getMonsterZone() {
        return monsterZone;
    }
}

