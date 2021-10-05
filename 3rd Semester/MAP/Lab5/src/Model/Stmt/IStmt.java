package Model.Stmt;

import Exception.MyException;
import Model.PrgState;
public interface IStmt {

    public PrgState execute(PrgState state) throws MyException, MyException;

}
