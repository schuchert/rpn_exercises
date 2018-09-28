package shoe;

import java.math.BigDecimal;

public class Add implements Operator {
    @Override
    public void execute(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.add(rhs));
    }
}
