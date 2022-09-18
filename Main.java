/*
 * Jason Boyett - jaboye2448
 * CIT 4423 01
 * Sept 10, 2022
 * macOS
 */

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
    static ImageIcon choiceIcon = new ImageIcon();
    static final String rock = "Rock";
    static final String paper = "Paper";
    static final String scissors = "Scissors";
    static final String lizard = "Lizard";
    static final String spock = "Spock";

    public static void main(String[] args) throws Exception {
        String playerChoice = getPlayerChoice();
        Random random = new Random();
        int aiChoice = random.nextInt(5 - 1) + 1;

        while (playerChoice.equalsIgnoreCase(getAiChoice(aiChoice))) {// makes sure the player choice an aiChoice are
                                                                      // not the same
            aiChoice = random.nextInt(5 - 1) + 1;
        }
        if (playerWins(playerChoice, aiChoice)) {
            JOptionPane.showMessageDialog(null, "YAY! You're a winner! The computer chose " + getAiChoice(aiChoice),
                    "Winner!", JOptionPane.INFORMATION_MESSAGE, choiceIcon);
        } else if (!playerWins(playerChoice, aiChoice)) {
            JOptionPane.showMessageDialog(null,
                    "Sorry :( the computer chose " + getAiChoice(aiChoice), "You lose", JOptionPane.INFORMATION_MESSAGE,
                    choiceIcon);
        }
        System.exit(0);

    }

    public static boolean playerWins(String playerChoice, int aiChoice) {// checks if the player won and returns true if
                                                                         // they did, otherwise returns false
        // 1 is rock
        // 2 is paper
        // 3 is scissors
        // 4 is lizard
        // 5 is spock
        if (playerChoice.equalsIgnoreCase(rock)) {
            return isWinner(aiChoice, 3, 4);
        } else if (playerChoice.equalsIgnoreCase(paper)) {
            return isWinner(aiChoice, 1, 5);
        } else if (playerChoice.equalsIgnoreCase(scissors)) {
            return isWinner(aiChoice, 2, 4);
        } else if (playerChoice.equalsIgnoreCase(lizard)) {
            return isWinner(aiChoice, 2, 5);
        } else if (playerChoice.equalsIgnoreCase(spock)) {
            return isWinner(aiChoice, 1, 3);
        }
        return false;
    }

    public static String getPlayerChoice() {
        try {
            ImageIcon rules = scaleImageIcon("rules.png", 250, 250);
            String choice = String.valueOf(JOptionPane.showInputDialog(null, "Chose Wisely!", null,
                    JOptionPane.INFORMATION_MESSAGE, rules, null, ""));
            if (choice.equalsIgnoreCase(rock)) {
                return rock;
            } else if (choice.equalsIgnoreCase(paper)) {
                return paper;
            }else if(choice.equalsIgnoreCase("null")){//when the user hits the cancle button or the red exit button then choice will return "null". If this is the case the program will exit
                System.exit(0);
                return null;
            } else if (choice.equalsIgnoreCase(scissors)) {
                return scissors;
            } else if (choice.equalsIgnoreCase(lizard)) {
                return lizard;
            } else if (choice.equalsIgnoreCase(spock)) {
                return spock;
            } else
                return getPlayerChoice();
        } catch (Exception e) {
            return getPlayerChoice();
        }
    }

    public static String getAiChoice(int aiChoice) {// turns aiChoice into a string from an int and sets the choiceIcon
                                                    // to the corresponding image
        if (aiChoice == 1) {
            choiceIcon = scaleImageIcon("rock.png", 250, 250);
            return rock;
        } else if (aiChoice == 2) {
            choiceIcon = scaleImageIcon("paper.png", 250, 250);
            return paper;
        } else if (aiChoice == 3) {
            choiceIcon = scaleImageIcon("scissors.png", 250, 250);
            return scissors;
        } else if (aiChoice == 4) {
            choiceIcon = scaleImageIcon("lizard.png", 250, 250);
            return lizard;
        } else if (aiChoice == 5) {
            choiceIcon = scaleImageIcon("spock.png", 250, 250);
            return spock;
        } else {
            return "none";
        }
    }

    public static ImageIcon scaleImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);// imports the image as an image icon
        Image image = icon.getImage();// casts the image as an Image object
        Image scaled = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);// scales the image
        icon.setImage(scaled);// recasts the scaled image as an ImageIcon
        return icon;// returns the scaled ImageIcon
    }

    public static boolean isWinner(int aiChoice, int winCondition1, int winCondition2) {// takes the aiChoice and
                                                                                        // compares it to two win
                                                                                        // conditions and returns true
                                                                                        // if the player wins
        if (aiChoice == winCondition1) {
            return true;
        } else if (aiChoice == winCondition2) {
            return true;
        }
        return false;
    }
}