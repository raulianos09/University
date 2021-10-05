package Repo;

import Model.PrgState;
import Model.Stmt.IStmt;
import Exception.MyException;

import java.io.IOException;
import java.util.List;

public interface IRepo {
    public List<PrgState> getPrgList();
    PrgState getCrtPrg();
    IStmt getOriginalProgram();
    void printPrgState(PrgState prgState) throws MyException, IOException;

    void addState(PrgState state);
}
