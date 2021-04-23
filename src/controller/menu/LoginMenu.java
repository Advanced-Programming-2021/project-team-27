package controller.menu;

import model.user.User;

public class LoginMenu {

    public void registerNewUser(String username, String nickname, String password) {
        new User(username, nickname, password);
    }

    public void loginUser(String username,String password){
        /*  MainMenu  */
    }

    public boolean wrongPasswordOrWrongUsername(String username,String password){
        if (User.getUserByUsername(username)==null){
            return true;
        }
        User user=User.getUserByUsername(username);
        if (!user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public boolean canRegister(String username, String nickname) {
        if (User.getUserByUsername(username) != null || User.getUserByNickname(nickname) != null) {
            return false;
        }
        return true;
    }




}
