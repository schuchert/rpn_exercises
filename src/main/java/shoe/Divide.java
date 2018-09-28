package shoe;

import java.math.BigDecimal;

import static java.math.MathContext.UNLIMITED;

public class Divide implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.divide(rhs, UNLIMITED));
    }
}
