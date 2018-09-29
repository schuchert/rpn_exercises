package shoe;

import java.math.BigDecimal;

public class Swap implements Operator {
    @Override
    public void execute(RpnStack values) {
        final BigDecimal rhs = values.pop();
        final BigDecimal lhs = values.pop();
        values.push(rhs);
        values.push(lhs);

    }
}
