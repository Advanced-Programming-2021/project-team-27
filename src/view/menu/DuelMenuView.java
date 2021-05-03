package view.menu;

import controller.DuelMenu;
import controller.ShopMenu;
import model.card.Card;
import view.CommandMatcher;
import view.ScanInput;
import view.TerminalOutput;

import java.util.regex.Matcher;

public class DuelMenuView {

    private String username;
    private DuelMenu duelMenu;

    public DuelMenuView(String username) {
        setUsername(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void duelMenuRun() {
        String input;
        while (true) {

            input = ScanInput.getInput();
            if (isInputNewDuelValid(input)) {
                newDuel(input);
            } else if (input.matches("card show [a-zA-Z\\s]+")) {
                cardShow(input);
            }
        }
    }

    public boolean isInputNewDuelValid(String input) {
        if (CommandMatcher.getCommandMatcher(input, "duel (.+)") != null) {
            if (CommandMatcher.getCommandMatcher(input, "--second-player [\\w]+") != null) {
                if (CommandMatcher.getCommandMatcher(input, "--rounds [\\d]") != null) {
                    if (CommandMatcher.getCommandMatcher(input, "--new") != null)
                        return true;
                }
            }
        }
        return false;
    }

    public void cardShow(String input) {
        Matcher matcher = CommandMatcher.getCommandMatcher(input, "card show ([a-zA-Z\\s]+)");
        assert matcher != null;
        String cardName = matcher.group(1);
        TerminalOutput.output(Card.showCard(cardName));
    }

    public void newDuel(String input) {
        Matcher matcher = CommandMatcher.getCommandMatcher(input, "--second-player ([\\w]+)");
        String secondPlayer = matcher.group(1);
        matcher = CommandMatcher.getCommandMatcher(input, "--rounds ([\\d]+)");
        int numberOfRounds = Integer.parseInt(matcher.group(1));
        duelMenu = new DuelMenu(this.username, secondPlayer, numberOfRounds);
    }

    public void newDuelWithAI() {

    }

    public void selectMonster(String input) {
        Matcher matcher;
        int number;
        boolean isOpponent;
    }

    public void selectCardByAddress(String input) {
        String Address;
        Matcher matcher;
    }

    public void deSelectCard() {

    }

    public void summon() {

    }

    public void set() {

    }

    public void changeCardPosition(String input) {
        Matcher matcher;
        boolean isOnAttack;
    }

    public void flipSummon() {

    }

    public void attack(String input) {
        int number;
        Matcher matcher;
    }

    public void directAttack() {

    }

    public void activeEffect() {

    }

    public void specialSummon() {

    }

    public void showGraveyard() {

    }

    public void selectedCardShow() {

    }

    public void checkForEndGame() {

    }

    public void surrender() {

    }

    public void increaseMoney(String input) {
        Matcher matcher;
        int amount;
    }

    public void increaseLifePoint(String input) {
        Matcher matcher;
        int amount;
    }

    public void selectHand(String input) {
        Matcher matcher;
        String cardName;

    }

    public void setWinner(String input) {
        Matcher matcher;
        String nickname;
    }


}