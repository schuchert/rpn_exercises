package shoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RpnCalculatorTest {

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
    void addThenSubtract() {
        calculator.enter(BigDecimal.valueOf(11));
        calculator.enter(BigDecimal.valueOf(2));
        calculator.enter(BigDecimal.valueOf(4));
        calculator.execute("add");
        calculator.execute("subtract");
        assertEquals(BigDecimal.valueOf(5), calculator.x());
    }

    @Test
    void subtractionWithOneValueNegatesValue() {
        calculator.enter(BigDecimal.valueOf(4));
        calculator.execute("subtract");
        assertEquals(BigDecimal.valueOf(-4), calculator.x());
    }

    @Test
    void divideByZeroWhenCalculatorEmpty() {
        assertThrows(ArithmeticException.class, () -> calculator.execute("divide"));
    }

    @Test
    void invalidOperatorThrowsException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> calculator.execute("==bogus=="));
        assertEquals("Operator: '==bogus==' does not exist", e.getMessage());
    }
}
