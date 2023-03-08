package Model.Expression;

import Model.Exceptions.MyException;

import Model.ADT.InterDictionary;
import Model.Value.InterValue;
import Model.ADT.InterHeap;

// Class for variable expression
public class VarExpression implements InterExpression {
    String id;

    public VarExpression(String id) {
        this.id = id;
    }

    @Override
    public InterValue eval(InterDictionary<String, InterValue> tbl, InterHeap heap) throws MyException {
        // if the variable is not in the table, throw an exception
        return tbl.lookUp(id);
    }

    @Override
    public String toString() {
        return this.id;
        // example: a
    }
}