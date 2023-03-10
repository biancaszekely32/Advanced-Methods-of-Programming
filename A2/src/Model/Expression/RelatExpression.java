package Model.Expression;

import Model.Exceptions.MyException;
import Model.Type.IntType;
import Model.ADT.InterDictionary;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.InterValue;
import Model.ADT.InterHeap;

import java.util.Objects;

/* Class that represents the relational expression */
public class RelatExpression implements InterExpression {
    InterExpression exp1;
    InterExpression exp2;
    String op;

    public RelatExpression(String op, InterExpression exp1, InterExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.op = op;
    }

    @Override
    public InterValue eval(InterDictionary<String, InterValue> tbl, InterHeap heap) throws MyException {
        /* evaluate the two operands */
        InterValue v1, v2;
        v1 = this.exp1.eval(tbl,heap);

        if (v1.getType().equals(new IntType())) { /* check if the first operand is an integer */
            v2 = this.exp2.eval(tbl,heap);

            if (v2.getType().equals(new IntType())) { /* check if the second operand is an integer */
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();

                if (Objects.equals(this.op, "<"))
                    return new BoolValue(n1 < n2); /* result of the "<" operation */
                else if (Objects.equals(this.op, "<="))
                    return new BoolValue(n1 <= n2); /* result of the "<=" operation */
                else if (Objects.equals(this.op, "=="))
                    return new BoolValue(n1 == n2); /* result of the "==" operation */
                else if (Objects.equals(this.op, "!="))
                    return new BoolValue(n1 != n2); /* result of the "!=" operation */
                else if (Objects.equals(this.op, ">="))
                    return new BoolValue(n1 >= n2); /* result of the ">=" operation */
                else if (Objects.equals(this.op, ">"))
                    return new BoolValue(n1 > n2); /* result of the ">" operation */
            } else
                throw new MyException("Second operand is not an integer.");
        }
        else
            throw new MyException("First operand is not an integer.");

        return null;
    }

    @Override
    public String toString() {
        return exp1.toString() + " " + op + " " + exp2.toString();
        /* example: a < b */
    }
}