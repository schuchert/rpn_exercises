package shoe;

import java.math.BigDecimal;

public class Push2 implements Operator {
    @Override
    public void execute(RpnStack values) {
        values.push(BigDecimal.valueOf(2));
    }
}
