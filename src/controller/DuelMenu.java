package controller;

import model.battle.Ai;
import model.battle.Phase;
import model.battle.Player;
import model.user.User;
import view.TerminalOutput;
import view.menu.MainMenuView;

import java.net.PortUnreachableException;
import java.util.regex.Matcher;

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
    private String terminalOutput = "";

    public DuelMenu(String currentUser, String secondUser, int numberOfRounds, boolean isAi) {
        setCurrentUser(User.getUserByUsername(currentUser));
        if (!isAi) {
            if (!isUsernameExist(secondUser)) {
                terminalOutput = "there is no player with this username";
                this.isDuelIsOn = false;
                return;
            }
            setSecondUser(User.getUserByUsername(secondUser));
        } else {
            this.isDuelIsOn = true;
        }
        if (!isPlayerHadActiveDeck(this.currentUser)) {
            terminalOutput = currentUser + " has no active deck";
            isDuelIsOn = false;
            return;
        }
        if (!isPlayerHadActiveDeck(this.secondUser)) {
            terminalOutput = secondUser + " has no active deck";
            isDuelIsOn = false;
            return;
        }
        if (!isActiveDeckValid(this.currentUser)) {
            terminalOutput = currentUser + "'s deck is invalid";
            isDuelIsOn = false;
            return;
        }
        if (!isActiveDeckValid(this.secondUser)) {
            terminalOutput = secondUser + "'s deck is invalid";
            isDuelIsOn = false;
            return;
        }
        if (numberOfRounds != 3 && numberOfRounds != 1) {
            terminalOutput = "number of rounds is not supported";
            isDuelIsOn = false;
            return;
        }
        setNumberOfRounds(numberOfRounds);
        isDuelIsOn = true;
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

    public void cardShow() {

    }

    public boolean isPlayerHadActiveDeck(User user) {
        return user.getActiveDeck() != null;
    }

    public boolean isUsernameExist(String username) {
        return User.getUserByUsername(username) != null;
    }

    public boolean isActiveDeckValid(User user) {
        return user.getActiveDeck().isValid();
    }

    public void showBoard() {

    }

    public void selectMonster(int number, boolean isOpponent) {

    }

    public void selectSpellOrTrap(int number, boolean isOpponent) {

    }

    public void selectField(int number, boolean isOpponent) {

    }

    public void selectHand(int number) {

    }

    public void deSelectCard() {

    }

    public void nextPhase() {

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
        //TODO
    }

    public void specialSummon() {
        //TODO
    }

    public void showGraveyard() {

    }

    public void selectedCardShow() {

    }

    public void surrender() {

    }

    public void increaseMoney(int amount) {

    }

    public void increaseLifePoint(int amount) {

    }

    public void selectForcedCard(String cardName) {

    }

    public void setWinner(String nickname) {

    }

    public boolean hasGameEnded() {
        return true;
    }

    public String getTerminalOutput() {
        String returnValue = terminalOutput;
        terminalOutput = "";
        return returnValue;
    }

}