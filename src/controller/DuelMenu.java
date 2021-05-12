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
    private int wholeNumberOfRounds;
    private int firstPlayerMaxLP = 0;
    private int secondPlayerMaxLP = 0;
    private int firstPlayerWins = 0;
    private int secondPlayerWins = 0;
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
        wholeNumberOfRounds = numberOfRounds;
        isDuelIsOn = true;
        firstPlayer = new Player(this.currentUser);
        secondPlayer = new Player(this.secondUser);
        this.phase=new Phase();
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

    public void cardShow(String cardName) {
        Card.showCard(cardName);
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
            if (monster == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 2) {
            monster = mat.getMonsterZone(i);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 3) {
            monster = mat.getMonsterZone(i2);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 4) {
            monster = mat.getMonsterZone(i3);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 5) {
            monster = mat.getMonsterZone(i4);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
            }
            opponentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else {
            terminalOutput = "invalid selection";
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
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 2) {
            card = mat.getSpellAndTrapZone(i);
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 3) {
            card = mat.getSpellAndTrapZone(i2);
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 4) {
            card = mat.getSpellAndTrapZone(i3);
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 5) {
            card = mat.getSpellAndTrapZone(i4);
            if (card == null) {
                terminalOutput = "no card found in the given position";
            }
            opponentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else {
            terminalOutput = "invalid selection";
        }
    }

    public void selectField(int number, boolean isOpponent) {
        Mat mat;
        if (isOpponent) {
            mat = opponentTurnPlayer.getMat();
            if (mat.getFieldZone() == null) {
                terminalOutput = "no card found in the given position";
            }
            terminalOutput = "card selected";
            opponentTurnPlayer.setCurrentSelectedCard(mat.getFieldZone());
            return;
        }
        mat = currentTurnPlayer.getMat();
        if (mat.getFieldZone() == null) {
            terminalOutput = "no card found in the given position";
        }
        terminalOutput = "card selected";
        currentTurnPlayer.setCurrentSelectedCard(mat.getFieldZone());
    }

    public void selectHand(int number) {
        if (number > 6 || number < 1) {
            terminalOutput = "invalid selection";
            return;
        }
        Card card = currentTurnPlayer.getMat().getHandCard(number - 1);
        if (card == null) {
            terminalOutput = "no card found in the given position";
            return;
        }
        terminalOutput = "card selected";
        currentTurnPlayer.setCurrentSelectedCard(card);
    }

    public void deSelectCard() {
        if (currentTurnPlayer.getCurrentSelectedCard()==null){
            terminalOutput = "no card selected yet";
            return;
        }
        terminalOutput = "card deselected";
        currentTurnPlayer.setCurrentSelectedCard(null);
    }

    public void nextPhase() {
        phase.nextPhase();
    }


    public void summon() {
        Mat mat=currentTurnPlayer.getMat();
        if (currentTurnPlayer.getCurrentSelectedCard() == null){
            terminalOutput="no card selected yet";
            return;
        }
        if (!(currentTurnPlayer.getCurrentSelectedCard() instanceof Monster)){
            terminalOutput = "you can't summon this card";
            return;
        }
        if (!phase.getCurrentPhase().equals("First Main Phase") && !phase.getCurrentPhase().equals("Second Main Phase")){
            terminalOutput = "action is not allowed in this phase";
            return;
        }
        if (mat.isMonsterZoneIsFull()){
            terminalOutput = "monster card zone is full";
            return;
        }
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
        Card card = currentTurnPlayer.getCurrentSelectedCard();
        String cardName = card.getName();
        Card.showCard(cardName);
    }

    public void surrender() {
        currentTurnPlayer.setLifePoint(0);
    }

    public void increaseMoney(int amount) {
        int currentMoney = currentTurnUser.getCredit();
        currentTurnUser.setCredit(currentMoney + amount);
    }

    public void increaseLifePoint(int amount) {
        int currentLP = currentTurnPlayer.getLifePoint();
        currentTurnPlayer.setLifePoint(currentLP + amount);
    }

    public void selectForcedCard(String cardName) {
        Card card = Card.getCardByName(cardName);
        currentTurnPlayer.addSelectedCard(card);
    }

    public void setWinner(String nickname) {
        String firstPlayerName = currentUser.getNickname();
        String secondPlayerName = secondUser.getNickname();
        if (firstPlayerName.equals(nickname))
            secondPlayer.setLifePoint(0);
        if (secondPlayerName.equals(nickname))
            firstPlayer.setLifePoint(0);
    }

    public boolean hasGameEnded() {
        int firstPlayerHealth = firstPlayer.getLifePoint();
        int secondPlayerHealth = secondPlayer.getLifePoint();
        if (firstPlayerHealth <= 0){
            secondPlayerWins++;
            secondPlayerMaxLP = Math.max(secondPlayerMaxLP, secondPlayer.getLifePoint());
            String username = secondUser.getUsername();
            terminalOutput += username + " won the game and the score is: " + firstPlayerWins + "-" + secondPlayerWins + "\n";
            if (numberOfRounds == 1) {
                int firstPlayerCredit = 100;
                int secondPlayerCredit = 1000 + secondPlayerMaxLP;
                if (wholeNumberOfRounds == 3) {
                    firstPlayerCredit = 300;
                    secondPlayerCredit = 3000 + secondPlayerMaxLP;
                }
                currentUser.setCredit(currentUser.getCredit() + firstPlayerCredit);
                secondUser.setCredit(secondUser.getCredit() + secondPlayerCredit);
                return true;
            }
            firstPlayer = new Player(this.currentUser);
            secondPlayer = new Player(this.secondUser);
            this.phase=new Phase();
            numberOfRounds--;
        }
        if (secondPlayerHealth <= 0){
            firstPlayerWins++;
            firstPlayerMaxLP = Math.max(firstPlayerMaxLP, firstPlayer.getLifePoint());
            String username = currentUser.getUsername();
            terminalOutput += username + " won the game and the score is: " + firstPlayerWins + "-" + secondPlayerWins + "\n";
            if (numberOfRounds == 1) {
                int secondPlayerCredit = 100;
                int firstPlayerCredit = 1000 + firstPlayerMaxLP;
                if (wholeNumberOfRounds == 3) {
                    secondPlayerCredit = 300;
                    firstPlayerCredit = 3000 + firstPlayerMaxLP;
                }
                currentUser.setCredit(currentUser.getCredit() + firstPlayerCredit);
                secondUser.setCredit(secondUser.getCredit() + secondPlayerCredit);
                return true;
            }
            firstPlayer = new Player(this.currentUser);
            secondPlayer = new Player(this.secondUser);
            this.phase=new Phase();
            numberOfRounds--;
        }
        return false;
    }

    public String getTerminalOutput() {
        String returnValue = terminalOutput;
        terminalOutput = "";
        return returnValue + "\n";
    }

}