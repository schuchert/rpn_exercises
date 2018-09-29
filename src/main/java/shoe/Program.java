package shoe;

import java.util.LinkedList;
import java.util.List;

public class Program implements Operator {
    public final String name;
    private List<Operator> operators;

    public Program(String name) {
        this.name = name;
        operators = new LinkedList<>();
    }

    public void add(Operator op) {
        operators.add(op);
    }

    @Override
    public void execute(RpnStack values) {
        operators.forEach(op -> op.execute(values));
    }
}
