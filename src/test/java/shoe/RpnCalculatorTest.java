package shoe;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpnCalculatorTest {
    @Test
    void initialValueZero() {
        RpnCalculator calculator = new RpnCalculator();
        assertEquals(BigDecimal.ZERO, calculator.x());
    }
}
