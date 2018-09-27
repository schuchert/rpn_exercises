package shoe;

import java.math.BigDecimal;
import java.util.Stack;

public class RpnStack {
    private Stack<BigDecimal> values;

    public RpnStack() {
        values = new Stack<>();
    }

    public BigDecimal peek() {
        return values.size() > 0 ? values.peek() : BigDecimal.ZERO;
    }

    public BigDecimal pop() {
        return values.size() > 0 ? values.pop() : BigDecimal.ZERO;
    }

    public void push(BigDecimal value) {
        values.push(value);
    }
}
