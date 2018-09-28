package shoe;

import java.math.BigDecimal;

public class RpnCalculator {
    private RpnStack values;

    public RpnCalculator() {
        values = new RpnStack();
    }

    public BigDecimal x() {
        return values.peek();
    }

    public void enter(BigDecimal value) {
        values.push(value);
    }

    public void execute(String operatorName) {
        operatorFor(operatorName).execute(values);
    }

    Operator operatorFor(String operatorName) {
        switch (operatorName) {
            case "add":
                return new Add();
            case "subtract":
                return new Subtract();
            case "multiply":
                return new Multiply();
            case "divide":
                return new Divide();
            case "pow":
                return new Pow();
            case "factorial":
                return new Factorial();
        }

        throw new IllegalArgumentException(String.format("Operator: '%s' does not exist", operatorName));
    }
}
