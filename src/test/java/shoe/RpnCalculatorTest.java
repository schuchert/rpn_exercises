package shoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RpnCalculatorTest {

    private RpnCalculator calculator;

    @BeforeEach
    void setup() {
        calculator = new RpnCalculator();
    }

    @Test
    void initialValueZero() {
        assertEquals(BigDecimal.ZERO, calculator.x());
    }

    @Test
    void addingTwoNumers() {
        calculator.enter(BigDecimal.valueOf(4));
        calculator.enter(BigDecimal.valueOf(4));
        calculator.add();
        assertEquals(BigDecimal.valueOf(8), calculator.x());
    }

    @Test
    void subtractingTwoNumers() {
        calculator.enter(BigDecimal.valueOf(2));
        calculator.enter(BigDecimal.valueOf(4));
        calculator.subtract();
        assertEquals(BigDecimal.valueOf(-2), calculator.x());
    }

    @Test
    void addThenSubtract() {
        calculator.enter(BigDecimal.valueOf(11));
        calculator.enter(BigDecimal.valueOf(2));
        calculator.enter(BigDecimal.valueOf(4));
        calculator.add();
        calculator.subtract();
        assertEquals(BigDecimal.valueOf(5), calculator.x());
    }

    @Test
    void multiplyingTwoNumbers() {
        calculator.enter(BigDecimal.valueOf(2));
        calculator.enter(BigDecimal.valueOf(4));
        calculator.multiply();
        assertEquals(BigDecimal.valueOf(8), calculator.x());
    }

    @Test
    void divideTwoNumbers() {
        calculator.enter(BigDecimal.valueOf(2));
        calculator.enter(BigDecimal.valueOf(4));
        calculator.divide();
        assertEquals(BigDecimal.valueOf(.5), calculator.x());
    }

    @Test
    void pow() {
        calculator.enter(BigDecimal.valueOf(4));
        calculator.enter(BigDecimal.valueOf(3));
        calculator.pow();
        assertEquals(BigDecimal.valueOf(64), calculator.x());
    }

    @Test
    void factorial() {
        calculator.enter(BigDecimal.valueOf(4));
        calculator.factorial();
        assertEquals(BigDecimal.valueOf(24), calculator.x());
    }

    @Test
    void addingWithNoNumbersEnteredIs0() {
        calculator.add();
        assertEquals(BigDecimal.ZERO, calculator.x());
    }

    @Test
    void subtractionWithOneValueNegatesValue() {
        calculator.enter(BigDecimal.valueOf(4));
        calculator.subtract();
        assertEquals(BigDecimal.valueOf(-4), calculator.x());
    }

    @Test
    public void divideByZeroWhenCalculatorEmpty() {
        assertThrows(ArithmeticException.class, calculator::divide);
    }
}
