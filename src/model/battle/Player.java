package model.battle;

import model.card.Card;
import model.mat.Mat;
import model.user.User;

import java.util.ArrayList;

public class Player {
    private User user;
    private ArrayList<Card> selectedCards = new ArrayList<>();
    private Card currentSelectedCard;
    private Mat mat;
    private int lifePoint;


    public Player (User user){
        setUser(user);
        this.lifePoint=8000;
        mat=new Mat();
        currentSelectedCard=null;
    }

    public void changeLifePoint(int change){
        this.lifePoint+=change;
    }

    public Mat getMat() {
        return mat;
    }

    private void setUser(User user) {
        this.user = user;
    }

    public void setCurrentSelectedCard(Card currentSelectedCard) {
        this.currentSelectedCard = currentSelectedCard;
        selectedCards.add(currentSelectedCard);
    }

    public void addSelectedCard(Card card){
        selectedCards.add(card);
    }

    public Card getCurrentSelectedCard() {
        return currentSelectedCard;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public int getLifePoint() {
        return lifePoint;
    }


    public void changeScore(){

    }
}
