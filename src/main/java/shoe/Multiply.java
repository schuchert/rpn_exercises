package shoe;

import java.math.BigDecimal;

public class Multiply extends BinaryOperator {
    @Override
    BigDecimal calculate(BigDecimal lhs, BigDecimal rhs) {
        return lhs.multiply(rhs);
    }
}
