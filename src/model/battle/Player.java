package model.battle;

import model.card.Card;
import model.user.User;

public class Player {
    private User user;
    private Card currentSelectedCard;

    public Player(User user) {
        setUser(user);
    }

    private void setUser(User user) {
        this.user = user;
    }

    public void setCurrentSelectedCard(Card currentSelectedCard) {
        this.currentSelectedCard = currentSelectedCard;
    }

    public Card getCurrentSelectedCard() {
        return currentSelectedCard;
    }
}
