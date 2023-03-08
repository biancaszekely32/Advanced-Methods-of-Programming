package Model.Expression;
import Model.ADT.InterDictionary;
import Model.Exceptions.MyException;
import Model.Type.IntType;
import Model.Value.InterValue;
import Model.Value.IntValue;
import Model.ADT.InterHeap;

public class ArithExpression implements InterExpression {
    InterExpression e1;
    InterExpression e2;
    char op; // 1-plus, 2-minus, 3-star, 4-divide

    public ArithExpression(char op, InterExpression e1, InterExpression e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }


    @Override
    public InterValue eval(InterDictionary<String, InterValue> tbl, InterHeap heap) throws MyException {
        // evaluate the two operands
        InterValue v1, v2;
        v1 = this.e1.eval(tbl,heap);

        if (v1.getType().equals(new IntType())) { // check if the first operand is an integer
            v2 = this.e2.eval(tbl,heap);

            if (v2.getType().equals(new IntType())) { // check if the second operand is an integer
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();

                if (this.op == '+')
                    return new IntValue(n1 + n2);
                else if (this.op == '-')
                    return new IntValue(n1 - n2);
                else if (this.op == '*')
                    return new IntValue(n1 * n2);
                else if (this.op == '/')
                    if (n2 == 0) throw new MyException("Division by zero.");
                    else return new IntValue(n1 / n2);
            } else
                throw new MyException("Second operand is not an integer");
        } else
            throw new MyException("First operand is not an integer.");
        return null;
    }

    @Override
    public String toString() {
        return this.e1.toString() + " " + this.op + " " + this.e2.toString();
        // example: 2 + 3
    }
}