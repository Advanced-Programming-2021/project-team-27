package model.battle;

public class Phase {

    private String currentPhase;

    public Phase() {
        currentPhase = "Draw Phase";
    }

    public void nextPhase() {
        if (currentPhase.equals("Draw Phase")) {
            currentPhase = "Standby Phase";
        }
        if (currentPhase.equals("Standby Phase")) {
            currentPhase = "First Main Phase";
        }
        if (currentPhase.equals("First Main Phase")) {
            currentPhase = "Battle Phase";
        }
        if (currentPhase.equals("Battle Phase")) {
            currentPhase = "Second Main Phase";
        }
        if (currentPhase.equals("Second Main Phase")) {
            currentPhase = "End Phase";
        }

    }


    public String getCurrentPhase() {
        return currentPhase;
    }

    public void drawPhase() {

    }

    public void standbyPhase() {

    }

    public void firstMainPhase() {

    }

    public void battlePhase() {

    }

    public void secondMainPhase() {

    }

    public void endPhase() {

    }


}
