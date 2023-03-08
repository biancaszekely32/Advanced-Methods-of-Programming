package Model.ADT;

import java.util.List;
import Model.Exceptions.MyException;

// Interface for the stack
public interface InterStack<T> {
    T pop() throws MyException;
    void push(T v);
    boolean isEmpty();

    List<T> getReversed();
}
