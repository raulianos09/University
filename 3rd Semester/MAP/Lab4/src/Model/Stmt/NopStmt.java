package Model.Stmt;

import Model.PrgState;
import Exception.MyException;

public class NopStmt implements IStmt{

    @Override
    public PrgState execute(PrgState state) throws MyException {
        return state;
    }

}
