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
    public static void main(String[] args) throws Exception {
        ImageIcon rules = scaleImageIcon("rules.png", 250, 250);
        
        String playerChoice = String.valueOf(JOptionPane.showInputDialog(null,"Chose Wisely!", null, JOptionPane.INFORMATION_MESSAGE, rules ,null, ""));
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
            JOptionPane.showMessageDialog(null, "YAY! you're a winner! the computer chose " + getAiChoice(aiChoice),"Winner!", JOptionPane.INFORMATION_MESSAGE,choiceIcon);
        } else if (playerWins(playerChoice, aiChoice) != true) {
            JOptionPane.showMessageDialog(null,
                    "Sorry :( the computer chose " + getAiChoice(aiChoice), "You lose", JOptionPane.INFORMATION_MESSAGE,choiceIcon);
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

    public static String getAiChoice(int aiChoice) {// turns aiChoice into a string from an int and sets the choiceIcon to the corresponding image
        if (aiChoice == 1) {
            choiceIcon = scaleImageIcon("rock.png",250, 250);
            return "rock";
        } else if (aiChoice == 2) {
            choiceIcon = scaleImageIcon("paper.png",250, 250);
            return "paper";
        } else if (aiChoice == 3) {
            choiceIcon = scaleImageIcon("scisors.png",250, 250);
            return "scissors";
        } else if (aiChoice == 4) {
            choiceIcon = scaleImageIcon("lizard.png",250, 250);
            return "lizard";
        } else if (aiChoice == 5) {
            choiceIcon = scaleImageIcon("spock.png",250, 250);
            return "spock";
        } else {
            return "none";
        }
    }

    public static ImageIcon scaleImageIcon(String path, int width, int height){
        ImageIcon icon = new ImageIcon(path);//imports the image as an image icon
        Image image = icon.getImage();//casts the image as an Image object
        Image scaled = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);//scales the image
        icon.setImage(scaled);//recasts the scaled image as an ImageIcon
        return icon;//returns the scaled ImageIcon
    }
}