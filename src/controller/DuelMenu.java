package controller;

import model.battle.Ai;
import model.battle.Phase;
import model.battle.Player;
import model.card.Card;
import model.card.Monster;
import model.mat.Mat;
import model.user.User;
import view.TerminalOutput;
import view.menu.MainMenuView;

import javax.swing.*;
import java.net.PortUnreachableException;
import java.util.regex.Matcher;

public class DuelMenu {
    private User currentUser;
    private User secondUser;
    private Player firstPlayer;
    private Player secondPlayer;
    private int numberOfRounds;
    private Player currentTurnPlayer;
    private Player opponentTurnPlayer;
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
            return;
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
        firstPlayer = new Player(this.currentUser);
        secondPlayer = new Player(this.secondUser);
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
        Monster monster;
        if (!isOpponent) {
            selectMonsterCheck(number, currentTurnPlayer, 3, 1, 4, 0);
            return;
        }
        selectMonsterCheck(number, opponentTurnPlayer, 1, 3, 0, 4);

    }

    private void selectMonsterCheck(int number, Player opponentTurnPlayer, int i, int i2, int i3, int i4) {
        Monster monster;
        Mat mat = opponentTurnPlayer.getMat();
        if (number == 1) {
            monster = mat.getMonsterZone(2);
            if (monster==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            TerminalOutput.output("card selected");
        } else if (number == 2) {
            monster = mat.getMonsterZone(i);
            if (monster==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            TerminalOutput.output("card selected");
        } else if (number == 3) {
            monster = mat.getMonsterZone(i2);
            if (monster==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            TerminalOutput.output("card selected");
        } else if (number == 4) {
            monster = mat.getMonsterZone(i3);
            if (monster==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            TerminalOutput.output("card selected");
        } else if (number == 5) {
            monster = mat.getMonsterZone(i4);
            if (monster==null){
                TerminalOutput.output("no card found in the given position");
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            TerminalOutput.output("card selected");
        }else {
            TerminalOutput.output("invalid selection");
        }
    }

    public void selectSpellOrTrap(int number, boolean isOpponent) {
        Card card;
        if (!isOpponent) {
            selectSpellOrTrapCheck(number, currentTurnPlayer, 3, 1, 4, 0);
        }
        selectSpellOrTrapCheck(number, opponentTurnPlayer, 1, 3, 0, 4);
        return;
    }

    private void selectSpellOrTrapCheck(int number, Player opponentTurnPlayer, int i, int i2, int i3, int i4) {
        Card card;
        Mat mat = opponentTurnPlayer.getMat();
        if (number == 1) {
            card = mat.getSpellAndTrapZone(2);
            if (card==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            TerminalOutput.output("card selected");
        } else if (number == 2) {
            card = mat.getSpellAndTrapZone(i);
            if (card==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            TerminalOutput.output("card selected");
        } else if (number == 3) {
            card = mat.getSpellAndTrapZone(i2);
            if (card==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            TerminalOutput.output("card selected");
        } else if (number == 4) {
            card = mat.getSpellAndTrapZone(i3);
            if (card==null){
                TerminalOutput.output("no card found in the given position");
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            TerminalOutput.output("card selected");
        } else if (number == 5) {
            card = mat.getSpellAndTrapZone(i4);
            if (card==null){
                TerminalOutput.output("no card found in the given position");
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            TerminalOutput.output("card selected");
        }else {
            TerminalOutput.output("invalid selection");
        }
    }

    public void selectField(int number, boolean isOpponent) {
        Mat mat;
        if (isOpponent){
            mat=opponentTurnPlayer.getMat();
            if (mat.getFieldZone() == null){
                TerminalOutput.output("no card found in the given position");
            }
            TerminalOutput.output("card selected");
            opponentTurnPlayer.setCurrentSelectedCard(mat.getFieldZone());
            return;
        }
        mat=currentTurnPlayer.getMat();
        if (mat.getFieldZone() == null){
            TerminalOutput.output("no card found in the given position");
        }
        TerminalOutput.output("card selected");
        currentTurnPlayer.setCurrentSelectedCard(mat.getFieldZone());
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