package shoe;

import java.math.BigDecimal;

public class Subtract extends BinaryOperator {
    @Override
    BigDecimal calculate(BigDecimal lhs, BigDecimal rhs) {
        return lhs.subtract(rhs);
    }
}
