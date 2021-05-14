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
import java.util.ArrayList;
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
        this.phase = new Phase();
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
        if (!isOpponent) {
            selectMonsterCheck(number, currentTurnPlayer, 3, 1, 4, 0);
            currentTurnPlayer.setSelectedName("Monster");
            switch (number){
                case 1:
                    currentTurnPlayer.setNumberOfMonsterZone(2);
                    break;
                case 2:
                    currentTurnPlayer.setNumberOfMonsterZone(3);
                    break;
                case 3:
                    currentTurnPlayer.setNumberOfMonsterZone(4);
                    break;
                case 4:
                    currentTurnPlayer.setNumberOfMonsterZone(0);
                    break;
                default:
                    break;
            }
            return;
        }
        selectMonsterCheck(number, opponentTurnPlayer, 1, 3, 0, 4);
        currentTurnPlayer.setSelectedName("MonsterOpponent");

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
            currentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 2) {
            monster = mat.getMonsterZone(i);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            currentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 3) {
            monster = mat.getMonsterZone(i2);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            currentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 4) {
            monster = mat.getMonsterZone(i3);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            currentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else if (number == 5) {
            monster = mat.getMonsterZone(i4);
            if (monster == null) {
                terminalOutput = "no card found in the given position";
            }
            currentTurnPlayer.setCurrentSelectedCard(monster);
            terminalOutput = "card selected";
        } else {
            terminalOutput = "invalid selection";
        }
    }

    public void selectSpellOrTrap(int number, boolean isOpponent) {
        Card card;
        if (!isOpponent) {
            selectSpellOrTrapCheck(number, currentTurnPlayer, 3, 1, 4, 0);
            currentTurnPlayer.setSelectedName("Spell");
        }
        selectSpellOrTrapCheck(number, opponentTurnPlayer, 1, 3, 0, 4);
        currentTurnPlayer.setSelectedName("SpellOpponent");
    }

    private void selectSpellOrTrapCheck(int number, Player opponentTurnPlayer, int i, int i1, int i2, int i3) {
        Card card;
        Mat mat = opponentTurnPlayer.getMat();
        if (number == 1) {
            card = mat.getSpellAndTrapZone(2);
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            currentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 2) {
            card = mat.getSpellAndTrapZone(i);
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            currentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 3) {
            card = mat.getSpellAndTrapZone(i1);
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            currentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 4) {
            card = mat.getSpellAndTrapZone(i2);
            if (card == null) {
                terminalOutput = "no card found in the given position";
                return;
            }
            currentTurnPlayer.setCurrentSelectedCard(card);
            terminalOutput = "card selected";
        } else if (number == 5) {
            card = mat.getSpellAndTrapZone(i3);
            if (card == null) {
                terminalOutput = "no card found in the given position";
            }
            currentTurnPlayer.setCurrentSelectedCard(card);
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
        currentTurnPlayer.setSelectedName("Field");
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
        currentTurnPlayer.setSelectedName("Hand");
        currentTurnPlayer.setCurrentSelectedCard(card);
    }

    public void deSelectCard() {
        if (currentTurnPlayer.getCurrentSelectedCard() == null) {
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
        Mat mat = currentTurnPlayer.getMat();
        if (currentTurnPlayer.getCurrentSelectedCard() == null) {
            terminalOutput = "no card selected yet";
            return;
        }
        if (!(currentTurnPlayer.getCurrentSelectedCard() instanceof Monster)) {
            terminalOutput = "you can't summon this card";
            return;
        }
        if (!phase.getCurrentPhase().equals("First Main Phase") && !phase.getCurrentPhase().equals("Second Main Phase")) {
            terminalOutput = "action is not allowed in this phase";
            return;
        }
        if (mat.isMonsterZoneIsFull()) {
            terminalOutput = "monster card zone is full";
            return;
        }
        //Other;
    }

    public void set() {
        Card card = currentTurnPlayer.getCurrentSelectedCard();
        Mat mat = currentTurnPlayer.getMat();
        if (card == null) {
            terminalOutput = "no card selected yet";
            return;
        }
        if (!currentTurnPlayer.getSelectedName().equals("Hand")) {
            terminalOutput = "you can't set this card";
            return;
        }
        if (card instanceof Monster && (!phase.getCurrentPhase().equals("First Main Phase") && !phase.getCurrentPhase().equals("Second Main Phase"))) {
            terminalOutput = "you can't do this action phase";
            return;
        }
        if (mat.isMonsterZoneIsFull()){
            terminalOutput = "monster card zone is full";
            return;
        }
        if (currentTurnPlayer.isSummoned()){
            terminalOutput = "you already summoned/set on this turn";
            return;
        }
        //set
        terminalOutput="set successfully";
    }

    public void changeCardPosition(boolean isOnAttack) {
        Card card=currentTurnPlayer.getCurrentSelectedCard();
        if (currentTurnPlayer.getCurrentSelectedCard()==null){
            terminalOutput = "no card is selected yet";
            return;
        }
        if (!currentTurnPlayer.getSelectedName().equals("Monster")){
            terminalOutput = "you can;t change this card position";
            return;
        }
        if ((!phase.getCurrentPhase().equals("First Main Phase") && !phase.getCurrentPhase().equals("Second Main Phase"))) {
            terminalOutput = "you can't do this action phase";
            return;
        }
        if ((isOnAttack && !card.isAttack()) || (!isOnAttack && card.isAttack())){
            terminalOutput = "this card is already in the wanted position";
            return;
        }
        if (currentTurnPlayer.getMat().isChangedCard(currentTurnPlayer.getNumberOfMonsterZone())){
            terminalOutput = "you already changed this card position in this turn";
            return;
        }
        terminalOutput = "monster card position changed successfully";
        currentTurnPlayer.getMat().setIsChanged(true, currentTurnPlayer.getNumberOfMonsterZone());
        card.setAttack(isOnAttack);
    }

    public void flipSummon() {

    }

    public void attack(int number) {


    }

    public void directAttack() {
        Card selectedCard = currentTurnPlayer.getCurrentSelectedCard();
    }

    public void activeEffect() {
        Card selectedCard = currentTurnPlayer.getCurrentSelectedCard();
        if (selectedCard == null) {
            terminalOutput = "no card is selected yet";
            return;
        }
        if (!selectedCard.getType().equals("Spell")) {
            terminalOutput = "activate effect is only for spell cards.";
            return;
        }
        if (!phase.getCurrentPhase().equals("Main Phase")) {
            terminalOutput = "you can’t activate an effect on this turn";
            return;
        }
        Mat mat = currentTurnPlayer.getMat();
        for (int i = 0; i < 5; i++){
            if (mat.getSpellAndTrapZone(i).getName().equals(selectedCard.getName())){
                terminalOutput = "you have already activated this card";
                return;
            }
        }
        if (mat.isSpellAndTrapZoneIsFull() && !selectedCard.isField()){
            terminalOutput = "spell card zone is full";
            return;
        }
        //NEEDS TO IMPLEMENT CARDS FIRST
        terminalOutput = "spell activated";
    }

    public void checkForQuickChangeTurn() {
        //TODO
    }

    public void ritualSummon() {
        //TODO
    }

    public void specialSummon() {
        //TODO
    }

    public void showGraveyard() {
        ArrayList <Card> graveyard = currentTurnPlayer.getMat().getGraveyard();
        if (graveyard.size() == 0){
            terminalOutput += "graveyard empty";
        }
        for (Card card : graveyard)
            terminalOutput = card.getName() + ":" + card.getDescription();
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