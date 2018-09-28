package shoe;

import java.math.BigDecimal;

public abstract class BinaryOperator implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(calculate(lhs, rhs));
    }

    abstract BigDecimal calculate(BigDecimal lhs, BigDecimal rhs);
}
