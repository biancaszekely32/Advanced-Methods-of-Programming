package Model.Expression;

import Model.Exceptions.MyException;
import Model.ADT.InterDictionary;
import Model.ADT.InterHeap;
import Model.Value.InterValue;
import Model.Value.RefValue;


/* Class that represents the ReadHeap expression */
public class ReadHeapExpression implements InterExpression{
    private final InterExpression expression;

    public ReadHeapExpression(InterExpression expression) {
        this.expression = expression;
    }

    @Override
    public InterValue eval(InterDictionary<String, InterValue> symTable, InterHeap heap) throws MyException {
        /* evaluate the expression */
        InterValue value = expression.eval(symTable, heap);

        if (value instanceof RefValue) { /* if the value is a RefValue */
            RefValue refValue = (RefValue) value;

            if (heap.containsKey(refValue.getAddress())) /* if the address is defined in the heap */
                return heap.get(refValue.getAddress());
            else
                throw new MyException("The address is not defined on the heap!");
        } else
            throw new MyException(String.format("%s not of RefType", value));
    }

    @Override
    public String toString() {
        return String.format("ReadHeap(%s)", expression);
        /* example: ReadHeap(a) */
    }
}
