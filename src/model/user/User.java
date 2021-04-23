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
    private int credit;
    private boolean isUserLoggedIn = false;

    public User(String username, String password, String nickname) {
        setUsername(username);
        setPassword(password);
        setNickname(nickname);
        setScore(score);
        cards = new ArrayList<>();
        decks = new HashMap<>();
        setCredit(0);
        allUsers.add(this);
    }

    public static User getUserByNickname(String nickname) {
        for (User user : allUsers) {
            if (user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

    public static User getUserByUsername(String username) {
        for (User user : allUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }


    public void setCredit(int credit) {
        this.credit = credit;
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

    public int getCredit() {
        return credit;
    }

    public void setActiveDeck(Deck activeDeck) {
        this.activeDeck = activeDeck;
    }

    public String getNickname() {
        return nickname;
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

    public void addCard(Card card){
        cards.add(card);
        setCredit(this.credit- card.getPrice());
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


    public boolean isDeckNameIdentical(String deckName) {

        //To Do
        return true;
    }

    public boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }
}
