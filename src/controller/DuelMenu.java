package controller;

import model.battle.Ai;
import model.battle.Phase;
import model.battle.Player;
import model.user.User;
import view.TerminalOutput;
import view.menu.MainMenuView;

import java.net.PortUnreachableException;

public class DuelMenu {
    private User currentUser;
    private User secondUser;
    private Player firstPlayer;
    private Player secondPlayer;
    private int numberOfRounds;
    private User currentTurnUser;
    private Phase phase;
    private Ai ai;
    private boolean isDuelIsOn;

    public DuelMenu (String currentUser,String secondUser,int numberOfRounds){
        setCurrentUser(User.getUserByUsername(currentUser));
        if (!isUsernameExist(secondUser)){
            TerminalOutput.output("there is no player whit this username");
            isDuelIsOn=false;
            return;
        }
        setSecondUser(User.getUserByUsername(secondUser));
        /*  Other Error Code  */
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public String cardShow(String cardName) {
        return "k";
    }

    public boolean isPlayerHadActiveDeck() {
        return true;
    }

    public boolean isUsernameExist(String username) {
        return User.getUserByUsername(username) != null;
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

    public void changeCardPosition(boolean isOnAttack) {

    }

    public void flipSummon() {

    }

    public void attack(int number) {

    }

    public void directAttack() {

    }

    public void activeEffect() {

    }

    public void checkForQuickChangeTurn() {

    }

    public void ritualSummon() {

    }

    public void showGraveyard() {

    }

    public void selectedCardShow() {

    }

    public void surrender(){

    }

    public void increaseMoney(int amount){

    }

    public void increaseLifePoint(int amount){

    }

    public void selectHand(String cardName){

    }

    public void setWinner(String nickname){

    }

}