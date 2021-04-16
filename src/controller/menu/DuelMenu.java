package controller.menu;

import model.battle.Player;
import model.user.User;

import java.net.PortUnreachableException;

public class DuelMenu {
    private User currentUser;
    private User secondUser;
    private Player firstPlayer;
    private Player secondPlayer;
    private int numberOfRounds;
    private User currentTurnUser;


    public String cardShow(String cardName) {
        return "k";
    }

    public boolean isPlayerHadActiveDeck() {
        return true;
    }

    public boolean isUsernameExist(String username) {
        return true;
    }

    public boolean isActiveDeckValid() {
        return true;
    }

    public void showBoard() {

    }

    public void selectMonster(int number, boolean isOpponent) {

    }

    public void selectCardByAddress(String address) {

    }

    public void deSelectCard() {

    }

    public void summon() {

    }

    public void set() {

    }

    public void changeCardPosition(boolean isOnAttack){

    }

    public void flipSummon(){

    }

    public void attack(int number){

    }

    public void directAttack(){

    }

    public void activeEffect(){

    }

    public void checkForQuickChangeTurn(){

    }


}
