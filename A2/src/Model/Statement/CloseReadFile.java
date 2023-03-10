package Model.Statement;
import Model.Exceptions.MyException;
import Model.Expression.InterExpression;
import Model.ProgramState;
import Model.Type.StringType;
import Model.ADT.InterDictionary;
import Model.Value.InterValue;
import Model.Value.StringValue;

import java.io.BufferedReader;
import java.io.IOException;

/* Class that represents the statement that closes a file */
public class CloseReadFile implements InterStatement {
    private final InterExpression expression;

    public CloseReadFile(InterExpression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        /* function that closes the file with the given name */
        InterValue value = expression.eval(state.getSymTable(), state.getHeap());

        if (!value.getType().equals(new StringType())) /* if the expression is not a string */
            throw new MyException(String.format("%s does not evaluate to StringValue", expression));

        StringValue fileName = (StringValue) value; /* cast the value to StringValue */
        InterDictionary<String, BufferedReader> fileTable = state.getFileTable(); /* get the file table */

        if (!fileTable.containsKey(fileName.getValue())) /* if the file is not in the file table */
            throw new MyException(String.format("%s is not present in the FileTable", value));

        BufferedReader br = fileTable.lookUp(fileName.getValue()); /* get the BufferedReader associated with the file name */

        try {
            br.close();
        } catch (IOException e) {
            throw new MyException(String.format("Unexpected error in closing %s", value));
        }

        fileTable.remove(fileName.getValue()); /* remove the file from the file table */
        state.setFileTable(fileTable); /* update the file table */

        return null;
    }

    @Override
    public String toString() {
        return String.format("CloseReadFile(%s)", expression.toString());
        /* example: CloseReadFile(var_f) */
    }
}
