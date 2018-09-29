package shoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    private RpnStack stack;
    private OperatorFactory factory;

    private static List<BigDecimal> listOf(Stream<Integer> values) {
        return values.map(BigDecimal::valueOf).collect(Collectors.toList());
    }

    private static List<BigDecimal> expect(Integer... values) {
        final List<Integer> list = Arrays.asList(values);
        Collections.reverse(list);
        return listOf(list.stream());
    }

    private static List<BigDecimal> enter(Integer... values) {
        return listOf(Arrays.stream(values));
    }

    private static Stream<Arguments> testValues() {
        return Stream.of(
                Arguments.of("add", enter(), expect(0)),
                Arguments.of("add", enter(4, 7), expect(11)),
                Arguments.of("subtract", enter(7), expect(-7)),
                Arguments.of("subtract", enter(4, 7), expect(-3)),
                Arguments.of("multiply", enter(4, 7), expect(28)),
                Arguments.of("divide", enter(24, 3), expect(8)),
                Arguments.of("factorial", enter(5), expect(120)),
                Arguments.of("pow", enter(3, 3), expect(27)),
                Arguments.of("pow", enter(10, 0), expect(1))
        );
    }

    @BeforeEach
    void init() {
        stack = new RpnStack();
        factory = new OperatorFactory();
    }

    @ParameterizedTest
    @MethodSource("testValues")
    void validateResultAndRegistration(String operatorName, List<BigDecimal> valuesToEnter, List<BigDecimal> expected) {
        Operator op = factory.operatorFor(operatorName);

        valuesToEnter.forEach(stack::push);
        op.execute(stack);

        expected.forEach(v -> assertEquals(0, v.compareTo(stack.pop())));
    }

    @Test
    void checkingForAllOperators() {
        final Set<Object> uniqueOperators = testValues().map(v -> v.get()[0]).collect(Collectors.toSet());
        assertEquals(factory.count(), uniqueOperators.size());
    }
}
