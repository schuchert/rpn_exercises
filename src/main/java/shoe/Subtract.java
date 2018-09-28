package shoe;

import java.math.BigDecimal;

public class Subtract implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.subtract(rhs));
    }
}
