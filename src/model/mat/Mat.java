package model.mat;

import model.card.Card;
import model.card.Monster;

import java.util.ArrayList;

public class Mat {
    private ArrayList<Card> graveyard;
    private Monster[] monsterZone = new Monster[5];
    private Card[] spellAndTrapZone = new Card[5];
    private Card fieldZone;
}
