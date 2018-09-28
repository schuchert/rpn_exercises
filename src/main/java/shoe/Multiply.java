package shoe;

import java.math.BigDecimal;

public class Multiply implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.multiply(rhs));
    }
}
