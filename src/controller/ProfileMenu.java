package controller;

import model.user.User;
import view.menu.MainMenuView;

public class ProfileMenu {
    private User currentUser;

    public void profileChange(){


    }

    public boolean canChangeNickname(String nickname){
        return true;
    }

    public boolean wrongPassword(String password){
        return true;
    }



}
