package Model.ADT;


import Model.Exceptions.MyException;
import Model.Value.InterValue;

import java.util.List;

// Interface for the list
public interface InterList<T> {
    void add(T e);
    String toString();
    T pop() throws MyException;
    boolean isEmpty();
    List<T> getList();
}