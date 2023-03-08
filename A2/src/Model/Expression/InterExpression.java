package Model.Expression;

import Model.Exceptions.MyException;

import Model.ADT.InterDictionary;
import Model.Value.InterValue;
import Model.ADT.InterHeap;

// Interface for all expressions
public interface InterExpression {
    InterValue eval(InterDictionary<String, InterValue> tbl, InterHeap heap) throws MyException;
}