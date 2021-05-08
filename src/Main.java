import model.Finisher;
import model.Initializer;
import model.user.User;
import org.json.simple.parser.ParseException;
import view.menu.LoginMenuView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Initializer.initialize();
        LoginMenuView loginMenuView = new LoginMenuView();
        loginMenuView.run();
        Finisher.finish();
    }

}
