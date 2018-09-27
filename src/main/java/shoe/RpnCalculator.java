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

    public void add() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.add(rhs));
    }

    public void subtract() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.subtract(rhs));
    }

    public void pow() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(BigDecimalMath.pow(lhs, rhs, UNLIMITED));
    }

    public void multiply() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.multiply(rhs));
    }

    public void divide() {
        BigDecimal rhs = values.pop();
        BigDecimal lhs = values.pop();
        values.push(lhs.divide(rhs, UNLIMITED));
    }

    public void factorial() {
        BigDecimal value = values.pop();
        values.push(BigDecimalMath.factorial(value, MathContext.UNLIMITED));
    }

}
