package model.battle;

import model.card.Card;
import model.mat.Mat;
import model.user.User;

import java.util.ArrayList;

public class Player {
    private User user;
    private Card currentSelectedCard;
    private Mat mat;
    private int lifePoint;


    public Player (User user){
        setUser(user);
        this.lifePoint=8000;
        mat=new Mat();
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
    }

    public Card getCurrentSelectedCard() {
        return currentSelectedCard;
    }



    public void changeCredit(int numberOfRounds,boolean isWin){

    }

    public void changeScore(){

    }
}
