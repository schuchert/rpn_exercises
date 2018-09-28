package shoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorFactoryTest {

    private OperatorFactory factory;

    @BeforeEach
    void init() {
        factory = new OperatorFactory();
    }

    @Test
    void invalidOperatorThrowsException() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> factory.operatorFor("==bogus=="));
        assertEquals("Operator: '==bogus==' does not exist", e.getMessage());
    }
}
