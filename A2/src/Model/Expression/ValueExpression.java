package Model.Expression;

import Model.ADT.InterDictionary;
import Model.Value.InterValue;
import Model.ADT.InterHeap;

// Class for giving a value to a variable
public class ValueExpression implements InterExpression {
    InterValue e;

    public ValueExpression(InterValue e) {
        this.e = e;
    }

    @Override
    public InterValue eval(InterDictionary<String, InterValue> tbl, InterHeap heap) {
        return this.e;
    }

    @Override
    public String toString() {
        return this.e.toString();
        // example: 5
    }
}