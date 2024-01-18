package gameEngine;

import java.util.Random;

public class GameEngine {

    public static final int GAME_MAXIMUM_RETRY_LIMIT = 4;
    private int counter = 0;

    private final int randomNumber = new Random().nextInt(10)+1;
    public String guess(int guessedNumber) {
        counter++;
        String response = null;
        String tryFormat = counter == 1 ? "try" : "tries";
        String winningTxt = String.format("You got it in %d %s",counter,tryFormat);


        if (counter == GAME_MAXIMUM_RETRY_LIMIT && guessedNumber != getRandomNumber()) {
            response = String.format("You didn't get it and you've had %d %s",counter,tryFormat);
        } else if (counter > GAME_MAXIMUM_RETRY_LIMIT) {
            response = "Sorry, you are limited to only 4 tries. Your game is over";
            
        }else {
            String hintTxt = null;
            if (guessedNumber < getRandomNumber()){
                hintTxt = "-> you're too low";
            }else if (guessedNumber > getRandomNumber()){
                hintTxt ="<- you're too high";
            }else {
                hintTxt = "";
            }
            String loseTxt = String.format("You didn't get it %s",hintTxt).trim();
            response = guessedNumber == getRandomNumber() ? winningTxt: loseTxt;

        }

        return response;
    }

    public int getRandomNumber(){
        return randomNumber;
    }

}
