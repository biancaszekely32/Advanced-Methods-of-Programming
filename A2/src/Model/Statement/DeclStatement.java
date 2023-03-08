package Model.Statement;

import Model.Exceptions.MyException;

import Model.ProgramState;

import Model.ADT.InterDictionary;
import Model.Value.InterValue;
import Model.Type.InterType;

// Class that represents a declaration statement
public class DeclStatement implements InterStatement {
    String name;
    InterType typ;

    public DeclStatement(String name, InterType typ) {
        this.name = name;
        this.typ = typ;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        // get the symbol table and check if the variable is already declared in it and if not add it to the symbol table
        InterDictionary<String, InterValue> symTable = state.getSymTable();

        if (symTable.containsKey(name))
            throw new MyException("Variable " + name + " already declared!");

        symTable.put(name, typ.defaultValue());
        state.setSymTable(symTable);
        return state;
    }

    @Override
    public String toString() {
        return typ.toString() + " " + name;
        // example: int a
    }
}