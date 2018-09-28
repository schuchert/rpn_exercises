package shoe;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperatorFactory {
    private Map<String, Operator> operators;

    public OperatorFactory() {
        operators = new HashMap<>();
        loadInto(operators);
    }

    public Operator operatorFor(String operatorName) {
        Operator op = operators.get(operatorName);
        if (op == null)
            throw new IllegalArgumentException(String.format("Operator: '%s' does not exist", operatorName));
        return op;
    }

    private void loadInto(Map<String, Operator> operators) {
        try (ScanResult result = scanClasses()) {
            operatorConstructors(result).forEach(c -> operators.put(c.getDeclaringClass().getSimpleName().toLowerCase(), oneOf(c)));
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Operator oneOf(Constructor<Operator> c) {
        try {
            return c.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ScanResult scanClasses() {
        return new ClassGraph().whitelistPackages("shoe").removeTemporaryFilesAfterScan().scan();
    }

    private List<Constructor<Operator>> operatorConstructors(ScanResult scanResult) {
        return scanResult
                .getClassesImplementing(Operator.class.getCanonicalName())
                .loadClasses()
                .stream()
                .filter(c -> !shouldSkip(c))
                .map(this::constructorFor)
                .collect(Collectors.toList());
    }

    private Constructor<Operator> constructorFor(Class<?> c) {
        try {
            @SuppressWarnings("unchecked") final Constructor<Operator> constructor = (Constructor<Operator>) c.getConstructor();
            return constructor;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }

    private boolean shouldSkip(Class<?> c) {
        return c.getConstructors()[0].getParameterCount() > 0 || Modifier.isAbstract(c.getModifiers());
    }

    public int count() {
        return operators.size();
    }
}
