package shoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgrammingTheCalculatorTest {

    private RpnCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new RpnCalculator();
    }

    @Test
    void simpleProgramExample() {
        final String powSqrt = "pow_sqrt";

        calculator.newProgram(powSqrt, "pow", "sqrt");

        calculator.enter(BigDecimal.valueOf(4));
        calculator.enter(BigDecimal.valueOf(4));

        calculator.execute(powSqrt);

        assertEquals(0, BigDecimal.valueOf(16).compareTo(calculator.x()));
    }

    @Test
    void longerProgramExample() {
        final String thirdLeg = "Pythagorean";

        calculator.newProgram(thirdLeg, "push2", "pow", "swap", "push2", "pow", "add", "sqrt");
        calculator.enter(BigDecimal.valueOf(3));
        calculator.enter(BigDecimal.valueOf(4));

        calculator.execute(thirdLeg);

        assertEquals(0, BigDecimal.valueOf(5).compareTo(calculator.x()));
    }

}
