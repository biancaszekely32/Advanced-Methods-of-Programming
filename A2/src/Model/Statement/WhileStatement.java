package Model.Statement;

import Model.Exceptions.MyException;
import Model.Expression.InterExpression;
import Model.ProgramState;
import Model.Type.BoolType;
import Model.ADT.InterStack;
import Model.Value.BoolValue;
import Model.Value.InterValue;

public class WhileStatement implements InterStatement{
    private final InterExpression expression;
    private final InterStatement statement;

    public WhileStatement(InterExpression expression, InterStatement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        InterValue value = expression.eval(state.getSymTable(), state.getHeap());
        InterStack<InterStatement> stack = state.getExeStack();

        if (!value.getType().equals(new BoolType()))
            throw new MyException(String.format("%s is not of BoolType", value));

        if (!(value instanceof BoolValue))
            throw new MyException(String.format("%s is not a BoolValue", value));

        BoolValue boolValue = (BoolValue) value;

        if (boolValue.getVal()) {
            stack.push(this);
            stack.push(statement);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("while(%s){%s}", expression, statement);
        /* example: while (a < 10) { a = a + 1; } */
    }
}
