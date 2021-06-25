package model.battle;

import model.card.Card;
import model.card.Monster;
import model.card.Spell;
import model.card.Trap;
import model.mat.Mat;
import model.user.Deck;
import model.user.MainDeck;
import model.user.User;
import view.TerminalOutput;

import java.util.ArrayList;
import java.util.Random;

public class Ai {
    private Player opponent;
    private Player ai;
    private Deck deck;

    public Ai(Player opponent, Player ai) {
        this.opponent = opponent;
        this.ai = ai;
    }

    public void setDeck() {
        User user = User.getUserByUsername("AI");
        deck = new Deck("AI", "AI");
        MainDeck mainDeck = deck.getMainDeck();
        for (int i = 0; i < 40; i++) {
            Random random = new Random();
            int randInt = random.nextInt(70);
            ArrayList<Card> allCards = Card.getAllCards();
            Card card = allCards.get(randInt);
            if (card instanceof Monster) {
                Monster monster = (Monster) card;
                Monster monster1 = new Monster(monster.getName(), monster.getLevel(), monster.getAttribute()
                        , monster.getMonsterType(), monster.getCardType(), monster.getAttack(), monster.getDefence(), monster.getDescription(), monster.getPrice());
                mainDeck.addCard(monster1);
            }
            if (card instanceof Spell) {
                Spell spell = (Spell) card;
                Spell spell1 = new Spell(spell.getName(), spell.getIcon(), spell.getDescription(), spell.getStatus(), spell.getPrice());
                mainDeck.addCard(spell1);
            }
            if (card instanceof Trap) {
                Trap trap = (Trap) card;
                Trap trap1 = new Trap(trap.getName(), trap.getIcon(), trap.getDescription(), trap.getStatus(), trap.getPrice());
                mainDeck.addCard(trap1);
            }
        }
        user.setActiveDeck(deck);
    }

    public void doTurn() {
        for (int i = 0; i < 5; i++) {
            if (ai.getMat().getMonsterZone(i) == null) {
                for (Card card : deck.getMainDeck().getMainDeckCards()) {
                    if (card instanceof Monster) {
                        ai.getMat().setMonsterZone(i, (Monster) card);
                        break;
                    }
                }
                break;
            }
        }
        Card card = ai.getMat().getMonsterZone(0);
        boolean doesOpponentHaveMonster = false;
        for (int i = 0; i < 5; i++) {
            if (opponent.getMat().getMonsterZone(i) != null) {
                doesOpponentHaveMonster = true;
            }
        }
        if (!doesOpponentHaveMonster) {
            System.out.println("you opponent receives " + card.getAttack() + " battle damage");
            opponent.setLifePoint(opponent.getLifePoint() - card.getAttack());
        }
    }

}
