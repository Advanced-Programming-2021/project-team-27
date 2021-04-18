package view.menu;

import model.user.User;
import view.ScanInput;
import view.TerminalOutput;

import java.util.Objects;

public class MainMenuView {

    private String currentUserLoggedInUsername;

    public MainMenuView(String username) {
        this.currentUserLoggedInUsername = username;
    }

    public void mainMenuRun() {
        String input;
        while (true) {
            input = ScanInput.getInput();
            if (input.matches("user logout") || input.matches("menu exit")) {
                userLogout();
                break;
            } else if (input.matches("menu show-current")) {
                TerminalOutput.output("Main Menu");
            } else if (input.matches("scoreboard show")) {

            } else if (input.matches("menu enter (.+)")) {
                enterMenu(input);
            }
        }
    }

    public void userLogout() {
        Objects.requireNonNull(User.getUserByUsername(currentUserLoggedInUsername)).setUserLoggedIn(false);
        TerminalOutput.output("user logged in successfully!");
    }

    private void enterMenu(String input) {

    }
}
