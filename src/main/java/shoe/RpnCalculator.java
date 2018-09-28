package shoe;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.MathContext.UNLIMITED;

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
        switch (operatorName) {
            case "add":
                add(values);
                break;
            case "subtract":
                subtract(values);
                break;
            case "multiply":
                multiply(values);
                break;
            case "divide":
                divide(values);
                break;
            case "pow":
                pow(values);
                break;
            case "factorial":
                factorial(values);
                break;
            default:
                throw new IllegalArgumentException(String.format("Operator: '%s' does not exist", operatorName));
        }
    }

    private void add(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.add(rhs));
    }

    private void subtract(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.subtract(rhs));
    }

    private void pow(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(BigDecimalMath.pow(lhs, rhs, UNLIMITED));
    }

    private void multiply(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.multiply(rhs));
    }

    private void divide(RpnStack values) {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.divide(rhs, UNLIMITED));
    }

    private void factorial(RpnStack values) {
        BigDecimal value = values.pop();
        values.push(BigDecimalMath.factorial(value, MathContext.UNLIMITED));
    }
}
