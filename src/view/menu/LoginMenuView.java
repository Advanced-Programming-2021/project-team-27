package view.menu;

import controller.menu.LoginMenu;
import view.CommandMatcher;
import view.ScanInput;

import java.util.regex.Matcher;

public class LoginMenuView {

    public void run() {
        String input;
        input = ScanInput.getInput();
        /*  Command Checker  */
    }


    public void createNewUser(String input) {
        String username = "Arad";
        String nickname = "Ghadi";
        String password = "123";
        String regex = "regex for new user";
        Matcher matcher = CommandMatcher.getCommandMatcher(input, regex);

        /* get some name */

        LoginMenu loginMenu = new LoginMenu();
        if (!loginMenu.canRegister(username, nickname)) {
            /*  error  */
        }
        loginMenu.registerNewUser(username, nickname, password);
    }

    public void loginUser(String input) {
        String username = " ";
        String password = " ";
        Matcher matcher = CommandMatcher.getCommandMatcher(input, " ");
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.loginUser(username, password);
    }

}
