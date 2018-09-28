package shoe;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;

import static java.math.MathContext.UNLIMITED;

public class Pow extends BinaryOperator {
    @Override
    BigDecimal calculate(BigDecimal lhs, BigDecimal rhs) {
        return BigDecimalMath.pow(lhs, rhs, UNLIMITED);
    }
}
