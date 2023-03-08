package Model.ADT;

import Model.Exceptions.MyException;

import java.util.Collection;
import java.util.Set;

// Interface for the dictionary
public interface InterDictionary<T1, T2> {
    void put(T1 key, T2 value);
    boolean containsKey(T1 key);
    T2 lookUp(T1 key);
    void update(T1 key, T2 value);
    Collection<T2> values();
    void remove(T1 key) throws MyException;;
    Set<T1> keySet();
}