package shoe;

import java.math.BigDecimal;

public class Add extends BinaryOperator {
    @Override
    BigDecimal calculate(BigDecimal lhs, BigDecimal rhs) {
        return lhs.add(rhs);
    }
}
