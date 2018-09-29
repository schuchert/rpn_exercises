package shoe;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;

public class Sqrt implements Operator {
    @Override
    public void execute(RpnStack values) {
        final BigDecimal operand = values.pop();
        values.push(BigDecimalMath.sqrt(operand, MathContext.UNLIMITED));
    }
}
