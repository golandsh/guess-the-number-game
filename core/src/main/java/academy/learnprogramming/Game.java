package academy.learnprogramming;

public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void reset(NumberGenerator generator);

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
