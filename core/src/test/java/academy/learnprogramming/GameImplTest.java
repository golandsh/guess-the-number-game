package academy.learnprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GameImplTest {
    @Mock
    private NumberGeneratorImpl numberGenerator;

    private GameImpl gameUnderTest;

    @BeforeEach
    void setup() {
        initMocks(this);
        gameUnderTest = new GameImpl();
        gameUnderTest.setNumberGenerator(numberGenerator);
        when(this.numberGenerator.next()).thenReturn(30);
        when(this.numberGenerator.getMaxNumber()).thenReturn(100);
        this.gameUnderTest.reset();
    }

    @Test
    void testGetNextNumber() {
        int number = this.gameUnderTest.getNumber();
        assertEquals(30, number);
    }

    @Test
    void testGuess() {
        this.gameUnderTest.setGuess(20);
        int guess = this.gameUnderTest.getGuess();
        assertEquals(20, guess);
    }

    @Test
    void testGetSmallest() {
        int smallest = this.gameUnderTest.getSmallest();
        assertEquals(0, smallest);
    }

    @Test
    void testGetBiggest() {
        int biggest = this.gameUnderTest.getBiggest();
        assertEquals(100, biggest);
    }

    @Test
    void testRemainingGuesses() {
        this.gameUnderTest.check();
        int remaining = this.gameUnderTest.getRemainingGuesses();
        assertEquals(9, remaining);
    }

    @Test
    void testValidRangeLow() {
        this.gameUnderTest.setGuess(-3);
        this.gameUnderTest.check();
        assertFalse(this.gameUnderTest.isValidNumberRange());
    }

    @Test
    void testValidRangeHigh() {
        this.gameUnderTest.setGuess(110);
        this.gameUnderTest.check();
        assertFalse(this.gameUnderTest.isValidNumberRange());
    }

    @Test
    void testValidRange() {
        this.gameUnderTest.setGuess(50);
        this.gameUnderTest.check();
        assertTrue(this.gameUnderTest.isValidNumberRange());
    }

    @Test
    void testGameWon() {
        this.gameUnderTest.setGuess(30);
        this.gameUnderTest.check();
        assertTrue(this.gameUnderTest.isGameWon());
    }

    @Test
    void testGameLost() {
        this.gameUnderTest.setGuess(10);
        for (int i = 0; i < 11; i++) {
            this.gameUnderTest.check();
        }
        assertTrue(this.gameUnderTest.isGameLost());
    }
}
