package Repo;

import Model.Exceptions.MyException;
import Model.ProgramState;
import java.io.IOException;
import java.util.List;

// Interface for the repository
public interface InterRepository {
    List<ProgramState> getProgramList();
    List<ProgramState> getProgramStates();
    void setProgramStates(List<ProgramState> programStates);
    void addProgram(ProgramState programState);
    void logPrgStaExe(ProgramState programState) throws MyException, IOException;
    void emptyLogFile() throws IOException;
}