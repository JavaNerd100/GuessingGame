package gameEngine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEngineTest {

    public static final int GAME_RANDOMNESS_RETRIES = 100;
    private GameEngine gameEngine;

    @BeforeEach
    void setUp() {
        gameEngine = new GameEngine();
    }

    @Test
    public void testSimpleWinSituation() {
        int randomNum = gameEngine.getRandomNumber();
        String message = gameEngine.guess(randomNum);
        assertEquals("You got it in 1 try",message);
    }

    @Test
    public void testOneWrongNegGuessSituation() {
        String message = gameEngine.guess(-5);
        assertEquals("You didn't get it -> you're too low", message);
    }


    @Test
    public void testOneWrongPosGuessSituation() {
        int randomNum = gameEngine.getRandomNumber() + 1;
        String message = gameEngine.guess(randomNum);
        assertEquals("You didn't get it <- you're too high", message);
    }

    @Test
    public void testRandomNumberGeneration(){
        int[] rndNumCount = new int[11];
        for (int counter=0; counter < GAME_RANDOMNESS_RETRIES; counter++) {
        GameEngine game = new GameEngine();
        int randomNum = game.getRandomNumber();
        rndNumCount[randomNum] = 1;
        }

        int sum = 0;
        for (int counter=0; counter < 11; counter++) {
            sum+=rndNumCount[counter]; // sum = sum + rndNumCount [cob
        }
        assertEquals (10, sum);
    }

    @Test
    public void testThreeWrongGuessesAndOneCorrect() {
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        int correctAnswer = gameEngine.getRandomNumber();
        String message = gameEngine.guess(correctAnswer);

        assertEquals ("You got it in 4 tries",message);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrect() {
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        int correctAnswer = gameEngine.getRandomNumber();
        String message = gameEngine.guess(correctAnswer);
        assertEquals ("You got it in 3 tries",message);
    }

    @Test
    public void testFourWrongGuesses() {
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        String message = gameEngine.guess(-3);
        assertEquals ("You didn't get it and you've had 4 tries",message);
    }


    @Test
    public void testTenWrongGuesses() {
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        gameEngine.guess(-3);
        String message = gameEngine.guess(-3);
        assertEquals ("Sorry, you are limited to only 4 tries. Your game is over",message);
    }

}
