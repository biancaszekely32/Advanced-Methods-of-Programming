package Model.Statement;

import Model.Exceptions.MyException;
import Model.Expression.InterExpression;
import Model.ProgramState;
import Model.Statement.InterStatement;
import Model.Type.RefType;
import Model.Type.InterType;
import Model.ADT.InterDictionary;
import Model.ADT.InterHeap;
import Model.Value.InterValue;
import Model.Value.RefValue;

/* Class for the WriteHeap statement */
public class NewStatement implements InterStatement {
    private final String varName; /* name of the variable */
    private final InterExpression expression; /* expression to be evaluated */

    public NewStatement(String varName, InterExpression expression) {
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        /* get the symbol table and the heap */
        InterDictionary<String, InterValue> symTable = state.getSymTable();
        InterHeap heap = state.getHeap();

        if (symTable.containsKey(varName)) { /* if the variable is defined in the symbol table */
            InterValue varValue = symTable.lookUp(varName);

            if ((varValue.getType() instanceof RefType)) { /* if the variable is of RefType */
                InterValue evaluated = expression.eval(symTable, heap);
                InterType locationType = ((RefValue) varValue).getLocationType();

                if (locationType.equals(evaluated.getType())) { /* if the type of the evaluated expression is the same as the location type */
                    int newPosition = heap.add(evaluated);
                    symTable.put(varName, new RefValue(newPosition, locationType));
                    state.setSymTable(symTable);
                    state.setHeap(heap);
                } else
                    throw new MyException(String.format("%s not of %s", varName, evaluated.getType()));
            } else {
                throw new MyException(String.format("%s in not of RefType", varName));
            }
        } else {
            throw new MyException(String.format("%s not in symTable", varName));
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("New(%s, %s)", varName, expression);
        /* example: New(v, 2+3) */
    }
}
