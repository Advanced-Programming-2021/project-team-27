package controller.menu;

import model.user.User;

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
