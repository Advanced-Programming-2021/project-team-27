package model.mat;

import model.card.Card;
import model.card.Monster;

import java.util.ArrayList;

public class Mat {
    private ArrayList<Card> graveyard;
    private Monster[] monsterZone = new Monster[5];
    private Card[] spellAndTrapZone = new Card[5];
    private Card fieldZone;

    public Mat(){
        for (int i = 0; i < 5; i++) {
            monsterZone[i]=null;
            spellAndTrapZone[i]=null;
        }
        fieldZone=null;
    }

    public void setFieldZone(Card fieldZone) {
        this.fieldZone = fieldZone;
    }

    public void addCardToGraveyard(Card card) {
        graveyard.add(card);
    }

    public void setMonsterZone(int number,Monster monster) {
        this.monsterZone[number]=monster;
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

    public Card getSpellAndTrapZone(int number) {
        return spellAndTrapZone[number];
    }

    public Monster getMonsterZone(int number) {
        return this.monsterZone[number];
    }
}

