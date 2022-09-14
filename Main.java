import java.lang.Math;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws Exception {
        String playerChoice = JOptionPane.showInputDialog(null, "chose wisely");
        Random random = new Random();
        int aiChoice = random.nextInt(5 - 1) + 1;
        System.out.println(getAiChoice(aiChoice) + "\n");
        System.out.println(aiChoice);

        while (playerChoice.equals(getAiChoice(aiChoice))) {
            aiChoice = random.nextInt(5 - 1) + 1;
            System.out.println(getAiChoice(aiChoice));
        }
        while (getAiChoice(aiChoice) == "none") {
            aiChoice = random.nextInt(5 - 1) + 1;
            System.out.println(getAiChoice(aiChoice));
        }
        if (playerWins(playerChoice, aiChoice) == true) {
            JOptionPane.showMessageDialog(null, "YAY! you're a winner! the computer chose " + getAiChoice(aiChoice));
        } else if (playerWins(playerChoice, aiChoice) != true) {
            JOptionPane.showMessageDialog(null,
                    "YAY! you totally suck at this. the computer chose " + getAiChoice(aiChoice));
        }

    }

    public static boolean playerWins(String playerChoice, int aiChoice) {// checks if the player won and returns true if
                                                                         // they did, otherwise returns false
        // 1 is rock
        // 2 is paper
        // 3 is scissors
        // 4 is lizard
        // 5 is spock
        playerChoice = playerChoice.toLowerCase();

        if (playerChoice.equals("rock")) {
            if (aiChoice == 4) {
                return true;
            } else if (aiChoice == 3) {
                return true;
            } else {
                return false;
            }
        } else if (playerChoice.equals("paper")) {
            if (aiChoice == 5) {
                return true;
            } else if (aiChoice == 1) {
                return true;
            } else {
                return false;
            }
        } else if (playerChoice.equals("scissors")) {
            if (aiChoice == 2) {
                return true;
            } else if (aiChoice == 4) {
                return true;
            } else {
                return false;
            }
        } else if (playerChoice.equals("lizard")) {
            if (aiChoice == 5) {
                return true;
            } else if (aiChoice == 2) {
                return true;
            } else {
                return false;
            }
        } else if (playerChoice.equals("spock")) {
            if (aiChoice == 3) {
                return true;
            } else if (aiChoice == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static String getAiChoice(int aiChoice) {// turns aiChoice into a string from an int
        if (aiChoice == 1) {
            return "rock";
        } else if (aiChoice == 2) {
            return "paper";
        } else if (aiChoice == 3) {
            return "scissors";
        } else if (aiChoice == 4) {
            return "lizard";
        } else if (aiChoice == 5) {
            return "spock";
        } else {
            return "none";
        }
    }
}