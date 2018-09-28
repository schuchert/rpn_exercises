package shoe;

import java.math.BigDecimal;

import static java.math.MathContext.UNLIMITED;

public class Divide extends BinaryOperator {
    @Override
    BigDecimal calculate(BigDecimal lhs, BigDecimal rhs) {
        return lhs.divide(rhs, UNLIMITED);
    }
}
