package shoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RpnStackTest {

    private RpnStack stack;

    @BeforeEach
    public void init() {
        stack = new RpnStack();
    }

    @Test
    void peekReturnsZeroUponCreation() {
        assertEquals(BigDecimal.ZERO, stack.peek());
    }

    @Test
    void popReturnsZeroUponCreation() {
        assertEquals(BigDecimal.ZERO, stack.pop());
    }
}
