package shoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    private RpnStack stack;
    private RpnCalculator calculator;

    private static Stream<Arguments> testValues() {
        return Stream.of(
                Arguments.of("add", Collections.emptyList(), 0),
                Arguments.of("add", Arrays.asList(4, 7), 11),
                Arguments.of("subtract", Collections.singletonList(7), -7),
                Arguments.of("subtract", Arrays.asList(4, 7), -3),
                Arguments.of("multiply", Arrays.asList(4, 7), 28),
                Arguments.of("divide", Arrays.asList(24, 3), 8),
                Arguments.of("factorial", Collections.singletonList(5), 120),
                Arguments.of("pow", Arrays.asList(3, 3), 27),
                Arguments.of("pow", Arrays.asList(10, 0), 1)
        );
    }

    @BeforeEach
    void init() {
        stack = new RpnStack();
        calculator = new RpnCalculator();
    }

    @ParameterizedTest
    @MethodSource("testValues")
    void validateResultAndRegistration(String operatorName, List<Integer> values, int expected) {
        Operator op = calculator.operatorFor(operatorName);

        values.stream().map(BigDecimal::valueOf).forEach(stack::push);
        op.execute(stack);

        assertEquals(BigDecimal.valueOf(expected), stack.peek());
    }
}
