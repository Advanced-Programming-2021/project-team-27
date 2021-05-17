package model.user;

import model.card.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


class UserTest {
    private static User user;

    @BeforeAll
    static void init() {
        user = new User("u", "n", "p");
    }

    @Test
    void getUserByNickname() {
        Assertions.assertNull(User.getUserByNickname("boo azar"));
        Assertions.assertNotNull(User.getUserByNickname("n"));
    }

    @Test
    void getUserByUsername() {
        Assertions.assertNull(User.getUserByUsername("boo azar"));
        Assertions.assertNotNull(User.getUserByUsername("u"));
    }

    @Test
    void getAllUsers() {
        Assertions.assertNotNull(User.getAllUsers());
        ArrayList<User> allUsers = User.getAllUsers();
        Assertions.assertEquals(1, allUsers.size());
        Assertions.assertSame(user, allUsers.get(0));
    }

    @Test
    void addToAllUsers() {
        User user2 = new User("a", "a", "a");
        ArrayList<User> allUsers = User.getAllUsers();
        Assertions.assertEquals(2, allUsers.size());
        User.addToAllUsers(user2);
        Assertions.assertEquals(3, allUsers.size());
    }

    @Test
    void setCredit() {
        user.setCredit(2000);
        Assertions.assertEquals(2000, user.getCredit());
    }

    @Test
    void setNickname() {
        user.setNickname("abbas");
        Assertions.assertEquals("abbas", user.getNickname());
        Assertions.assertNotNull(User.getUserByNickname("abbas"));
        user.setNickname("n");
    }

    @Test
    void setUsername() {
        user.setUsername("abbas");
        Assertions.assertEquals("abbas", user.getUsername());
        Assertions.assertNotNull(User.getUserByUsername("abbas"));
        user.setUsername("u");
    }

    @Test
    void setScore() {
        user.setScore(10);
        Assertions.assertEquals(10, user.getScore());
    }

    @Test
    void setPassword() {
        user.setPassword("pp");
        Assertions.assertEquals("pp", user.getPassword());
        user.setPassword("p");
    }

    @Test
    void setActiveDeck() {
        Deck deck = new Deck("deck", "u");
        user.addDeck("deck", deck);
        user.setActiveDeck(deck);
        Assertions.assertSame(deck, user.getActiveDeck());
    }

    @Test
    void getNickname() {
        Assertions.assertEquals("n", user.getNickname());
    }

    @Test
    void getUsername() {
        Assertions.assertEquals("u", user.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("p", user.getPassword());
    }


    @Test
    void addCard() {
        Card card = new Card();
        Assertions.assertNotNull(user.getCards());
        user.addCard(card);
        Assertions.assertEquals(1, user.getCards().size());
    }

    @Test
    void getDecks() {
        Assertions.assertNotNull(user.getDecks());
        HashMap<String, Deck> decks = user.getDecks();
        Assertions.assertTrue(decks.containsKey("deck"));
        user.deleteDeck("deck");
        Assertions.assertEquals(0, decks.size());
    }

    @Test
    void setUserLoggedIn() {
        Assertions.assertFalse(user.isUserLoggedIn());
        user.setUserLoggedIn(true);
        Assertions.assertTrue(user.isUserLoggedIn());
    }
}