package shoe;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;

import static java.math.MathContext.UNLIMITED;

public class Pow implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(BigDecimalMath.pow(lhs, rhs, UNLIMITED));
    }
}
