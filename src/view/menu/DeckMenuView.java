package view.menu;

import controller.ShopMenu;
import view.ScanInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckMenuView {

        public void deckMenuRun(){
            String input;
            Matcher matcher;
            while (true){
                input = ScanInput.getInput();
                if ((matcher = getMatcher(input, "deck create ([\\w]+)")).matches())
                    createDeck(matcher);
                if ((matcher = getMatcher(input, "deck delete ([\\w]+)")).matches())
                    deleteDeck(matcher);
                if ((matcher = getMatcher(input, "deck set-activate ([\\w]+)")).matches())
                    setActive(matcher);
                if ((matcher = getMatcher(input, "deck add-card --card ([\\w]+) --deck ([\\w]+)( --side|)")).matches())
                    addCardToDeck(matcher);
                if ((matcher = getMatcher(input, "deck rm-card --card ([\\w]+) --deck ([\\w]+)( --side|)")).matches())
                    removeCardFromDeck(matcher);
                if ((getMatcher(input, "deck show --all")).matches())
                    showAllDeck();
                if ((matcher = getMatcher(input, "deck show --deck-name ([\\w]+)( --side|)")).matches())
                    showOneDeck(matcher);
                if ((getMatcher(input, "deck show --cards")).matches())
                    showAllCards();
            }
        }

        public void cardShow(Matcher matcher){
            ShopMenu shopMenu=new ShopMenu();
            System.out.println(shopMenu.cardShow("ko"));

        }

        public void createDeck(Matcher matcher){
        }

        public void deleteDeck(Matcher matcher){
        }

        public void setActive(Matcher matcher){
        }

        public void addCardToDeck(Matcher matcher){
            String deckName;
            String cardName;
            boolean isSideDeck;
        }

        public void removeCardFromDeck(Matcher matcher){
            String deckName;
            String cardName;
            boolean isSideDeck;
        }

        public void showAllDeck(){

        }

        public void showOneDeck(Matcher matcher){
            String deckName;
            boolean isSideDeck;
        }
        public void showAllCards(){

        }

        private Matcher getMatcher(String input, String regex){
            Pattern pattern = Pattern.compile(regex);
            return pattern.matcher(input);
        }
}
