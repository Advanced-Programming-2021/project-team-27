package view.menu;

import controller.menu.ShopMenu;

import java.util.regex.Matcher;

public class DuelMenuView {


    public void duelMenuRun() {
        String input;
    }

    public void cardShow(String input) {
        ShopMenu shopMenu = new ShopMenu();
        System.out.println(shopMenu.cardShow("ko"));

    }

    public void newDuel(String input) {
        String secondPlayer;
        int numberOfRounds;
        Matcher matcher;
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

    public void changeCardPosition(String input){
        Matcher matcher;
        boolean isOnAttack;
    }

    public void flipSummon(){

    }

    public void attack(String input){
        int number;
        Matcher matcher;
    }

    public void directAttack(){

    }

    public void activeEffect(){

    }


}
