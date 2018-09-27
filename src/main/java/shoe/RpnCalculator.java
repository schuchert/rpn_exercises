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
                add();
                break;
            case "subtract":
                subtract();
                break;
            case "multiply":
                multiply();
                break;
            case "divide":
                divide();
                break;
            case "pow":
                pow();
                break;
            case "factorial":
                factorial();
                break;
            default:
                throw new IllegalArgumentException(String.format("Operator: '%s' does not exist", operatorName));
        }
    }

    private void add() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.add(rhs));
    }

    private void subtract() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.subtract(rhs));
    }

    private void pow() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(BigDecimalMath.pow(lhs, rhs, UNLIMITED));
    }

    private void multiply() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.multiply(rhs));
    }

    private void divide() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.divide(rhs, UNLIMITED));
    }

    private void factorial() {
        BigDecimal value = values.pop();
        values.push(BigDecimalMath.factorial(value, MathContext.UNLIMITED));
    }
}
