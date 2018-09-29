package shoe;

import java.math.BigDecimal;

public class RpnCalculator {
    private RpnStack values;
    private final OperatorFactory factory;

    public RpnCalculator() {
        values = new RpnStack();
        factory = new OperatorFactory();
    }

    public BigDecimal x() {
        return values.peek();
    }

    public void enter(BigDecimal value) {
        values.push(value);
    }

    public void execute(String operatorName) {
        factory.operatorFor(operatorName).execute(values);
    }

    public void newProgram(String name, String... steps) {
        factory.newProgram(name, steps);
    }
}
