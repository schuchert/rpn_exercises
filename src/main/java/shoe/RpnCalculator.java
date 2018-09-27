package shoe;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

public class RpnCalculator {

    public static final MathContext UNLIMITED = MathContext.UNLIMITED;
    private Stack<BigDecimal> values;

    public RpnCalculator() {
        values = new Stack<>();
    }

    public BigDecimal x() {
        return peek();
    }

    public void enter(BigDecimal value) {
        values.push(value);
    }

    public void add() {
        BigDecimal rhs = pop();
        BigDecimal lhs = pop();
        values.push(lhs.add(rhs));
    }

    public void subtract() {
        BigDecimal rhs = pop();
        BigDecimal lhs = pop();
        values.push(lhs.subtract(rhs));
    }

    public void pow() {
        BigDecimal rhs = pop();
        BigDecimal lhs = pop();
        values.push(BigDecimalMath.pow(lhs, rhs, UNLIMITED));
    }

    public void multiply() {
        BigDecimal rhs = pop();
        BigDecimal lhs = pop();
        values.push(lhs.multiply(rhs));
    }

    public void divide() {
        BigDecimal rhs = pop();
        BigDecimal lhs = pop();
        values.push(lhs.divide(rhs));
    }

    public void factorial() {
        BigDecimal value = pop();
        values.push(BigDecimalMath.factorial(value, MathContext.UNLIMITED));
    }

    BigDecimal peek() {
        return values.size() > 0 ? values.peek() : BigDecimal.ZERO;
    }

    BigDecimal pop() {
        return values.size() > 0 ? values.pop() : BigDecimal.ZERO;
    }
}
