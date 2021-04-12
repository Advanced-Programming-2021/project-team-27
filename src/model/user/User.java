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
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.score = 0;
        cards = new ArrayList<>();
        decks = new HashMap<>();
        this.zekhametKir = 0;
        allUsers.add(this);
    }

}
