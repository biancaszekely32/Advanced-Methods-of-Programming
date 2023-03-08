package Model.Statement;

import Model.Exceptions.MyException;

import Model.ProgramState;

// Interface for all statements (statements are the basic building blocks of the program)
public interface InterStatement {
    ProgramState execute(ProgramState state) throws MyException;
}