package controller;

import model.user.User;
import view.TerminalOutput;
import view.menu.MainMenuView;

public class ProfileMenu {
    private User currentUser;

    public ProfileMenu (String username){
        currentUser=User.getUserByUsername(username);
    }

    public void profileChangeNickname(String nickname){
        if (!canChangeNickname(nickname)){
            TerminalOutput.output("user with nickname "+nickname+" already exists");
            return;
        }
        currentUser.setNickname(nickname);
        TerminalOutput.output("nickname changed successfully");
    }

    public void profileChangePassword(String currentPassword,String newPassword){
        if (wrongPassword(currentPassword)){
            TerminalOutput.output("current password invalid");
            return;
        }
        if (currentPassword.equals(newPassword)){
            TerminalOutput.output("please enter new password");
            return;
        }
        currentUser.setPassword(newPassword);
        TerminalOutput.output("password changed successfully!");
    }

    public boolean canChangeNickname(String nickname){
        return User.getUserByNickname(nickname) == null;
    }

    public boolean wrongPassword(String password){
        return !currentUser.getPassword().equals(password);
    }



}
