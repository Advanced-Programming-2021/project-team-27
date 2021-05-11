package model.battle;

import model.card.Card;
import model.mat.Mat;
import model.user.User;

import java.util.ArrayList;

public class Player {
    private User user;
    private Card currentSelectedCard;
    private Mat mat;
    private String selectedName;
    private boolean isSummoned = false;
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

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }

    public String getSelectedName() {
        return selectedName;
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

    public boolean isSummoned() {
        return isSummoned;
    }

    public void changeCredit(int numberOfRounds, boolean isWin){

    }

    public void changeScore(){

    }
}
