package shoe;

import java.math.BigDecimal;

public abstract class BinaryOperator implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();

        BigDecimal result = calculate(lhs, rhs);

        values.push(result);
    }

    abstract BigDecimal calculate(BigDecimal lhs, BigDecimal rhs);
}
