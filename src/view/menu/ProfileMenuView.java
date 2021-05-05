package view.menu;

import controller.ProfileMenu;
import view.CommandMatcher;
import view.ScanInput;
import view.TerminalOutput;

import java.net.CookieHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenuView {

    private String currentUsername;
    private ProfileMenu profileMenu;

    public ProfileMenuView(String currentUsername) {
        setCurrentUsername(currentUsername);
        profileMenu=new ProfileMenu(currentUsername);
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    public void profileMenuRun() {
        String input;
        while (true) {
            input = ScanInput.getInput();
            if (input.matches("menu exit")) {
                TerminalOutput.output("exit successfully!");
                break;
            } else if (input.matches("profile change --nickname ([^ ]+)")) {
                profileChangeNickname(input);
            } else if (isInputChangePasswordValid(input)) {
                profileChangePassword(input);
            } else if (input.matches("menu show-current")) {
                TerminalOutput.output("Profile Menu");
            } else if (input.matches("menu enter (.+)")) {
                TerminalOutput.output("menu navigation is not possible");
            } else {
                TerminalOutput.output("invalid command");
            }
        }
    }

    public void profileChangeNickname(String input) {
        Matcher matcher = CommandMatcher.getCommandMatcher(input, "profile change --nickname ([^ ]+)");
        String nickname = matcher.group(1);
        profileMenu.profileChangeNickname(nickname);
    }

    public void profileChangePassword(String input) {
        Matcher matcherForNewPassword=CommandMatcher.getCommandMatcher(input,"--new ([^ ]+)");
        String newPassword=matcherForNewPassword.group(1);
        Matcher matcherForCurrentPassword= CommandMatcher.getCommandMatcher(input,"--current ([^ ]+)");
        String currentPassword=matcherForCurrentPassword.group(1);
        profileMenu.profileChangePassword(currentPassword,newPassword);
    }

    public boolean isInputChangePasswordValid(String input){
        if (CommandMatcher.getCommandMatcher(input,"profile change (.+)") != null){
            if (CommandMatcher.getCommandMatcher(input,"--password") != null){
                if (CommandMatcher.getCommandMatcher(input,"--current [^ -]+") !=null){
                    if (CommandMatcher.getCommandMatcher(input,"--new [^ -]+")!=null)
                        return true;
                }
            }
        }
        return false;
    }


}
