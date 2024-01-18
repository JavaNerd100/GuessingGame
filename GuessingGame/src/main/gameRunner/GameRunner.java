package gameRunner;

import gameEngine.GameEngine;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Boolean loopShouldContinue = true;
        do {
            String userInput = System.console().readLine("Please enter a number between 1 to 10 inclusively..!");
            if ("q".equals(userInput)) {
                return;
            }

            String output = gameEngine.guess(Integer.parseInt(userInput));
            System.out.println(output);

            if (output.contains("You got it") || output.contains("over")) {
                loopShouldContinue = false;
            }
        }while (loopShouldContinue);

    }
}
