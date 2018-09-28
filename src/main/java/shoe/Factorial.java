package shoe;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;

public class Factorial implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal value = values.pop();
        values.push(BigDecimalMath.factorial(value, MathContext.UNLIMITED));
    }
}
