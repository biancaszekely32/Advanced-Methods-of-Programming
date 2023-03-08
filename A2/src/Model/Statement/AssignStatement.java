package Model.Statement;

import Model.Exceptions.MyException;

import Model.ProgramState;

import Model.Expression.InterExpression;
import Model.Type.InterType;
import Model.ADT.InterDictionary;
import Model.Value.InterValue;

// Class that represents an assignment statement
public class AssignStatement implements InterStatement {
    private final String id;
    private final InterExpression exp;

    public AssignStatement(String id, InterExpression exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return this.id + " = " + this.exp.toString();
        // example: a = 5 + 2
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        // get the symbol table from the program state and set the symbol table in the program state
        InterDictionary<String, InterValue> symTbl = state.getSymTable();

        if (symTbl.containsKey(id)) { // if the symbol table contains the id
            InterValue val = exp.eval(symTbl, state.getHeap());
            InterType typId = (symTbl.lookUp(id)).getType();

            if (val.getType().equals(typId)) // value = type of the id
                symTbl.update(id, val);
            else
                throw new MyException("Declared type of variable " + id + " and type of the assigned expression do not match.");
        } else
            throw new MyException("The used variable " + id + " was not declared before.");

        state.setSymTable(symTbl);
        return state;
    }

}