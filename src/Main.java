import model.Initializer;
import view.menu.LoginMenuView;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        Initializer.initialize();
        LoginMenuView loginMenuView = new LoginMenuView();
        loginMenuView.run();
    }

}
