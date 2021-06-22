package model.battle;

import model.card.Card;
import model.card.Monster;
import model.user.Deck;
import model.user.MainDeck;
import model.user.User;

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
        for (int i = 0; i < 40; i++) {
            deck.getMainDeck().addCard(Card.getCardByName("Wattkid"));
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
        opponent.setLifePoint(opponent.getLifePoint() - 500);
    }
}
