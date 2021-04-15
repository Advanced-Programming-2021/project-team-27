package model.user;

import model.card.Card;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private static ArrayList<User> allUsers = new ArrayList<>();

    private String username;
    private String password;
    private String nickname;
    private int score;
    private Deck activeDeck;
    private HashMap<String, Deck> decks;
    private ArrayList<Card> cards;
    private int zekhametKir;



    public User(String username, String password, String nickname) {
        setUsername(username);
        setPassword(password);
        setNickname(nickname);
        setScore(score);
        cards = new ArrayList<>();
        decks = new HashMap<>();
        this.zekhametKir = 0;
        allUsers.add(this);
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Deck getActiveDeck() {
        return activeDeck;
    }

    public HashMap<String, Deck> getDecks() {
        return decks;
    }
}
