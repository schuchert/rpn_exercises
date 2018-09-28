package shoe;

public class OperatorFactory {
    public Operator operatorFor(String operatorName) {
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
