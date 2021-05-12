package model.mat;

import model.card.Card;
import model.card.Monster;

import java.util.ArrayList;

public class Mat {
    private ArrayList<Card> graveyard;
    private Monster[] monsterZone = new Monster[5];
    private Card[] spellAndTrapZone = new Card[5];
    private Card fieldZone;
    private Card[] handCard = new Card[6];
    private boolean[] isChanged = new boolean[5];

    public Mat(){
        for (int i = 0; i < 5; i++) {
            monsterZone[i]=null;
            spellAndTrapZone[i]=null;
            handCard[i]=null;
            isChanged[i]=false;
        }
        handCard[5]=null;
        fieldZone=null;
    }

    public void setIsChanged(boolean isChanged,int number) {
        this.isChanged[number] = isChanged;
    }

    public boolean isChangedCard(int number){
        return isChanged[number];
    }

    public boolean setHandCard(Card card){
        for (int i = 0; i < 6; i++) {
            if (handCard[i]==null){
                handCard[i]=card;
                return true;
            }
        }
        return false;
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

    public Card getHandCard(int number){
        return this.handCard[number];
    }

    public Monster getMonsterZone(int number) {
        return this.monsterZone[number];
    }

    public boolean isMonsterZoneIsFull(){
        for (int i = 0; i < 5; i++) {
            if (monsterZone[i] == null){
                return false;
            }
        }
        return true;
    }
}

