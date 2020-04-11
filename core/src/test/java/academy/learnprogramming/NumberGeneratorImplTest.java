package academy.learnprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGeneratorImplTest {
    NumberGeneratorImpl numberGenerator;

    @Test
    void testGetMaxNumber() {
        numberGenerator = new NumberGeneratorImpl();
        int result = this.numberGenerator.getMaxNumber();

        assertEquals(100, result);
    }
}
