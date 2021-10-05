package Model.Stmt;

import Model.ADT.IMyDictionary;
import Model.PrgState;
import Exception.MyException;
import Model.Exp.Exp;
import Model.Type.StringType;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFileStmt implements IStmt {
    private Exp exp;

    public CloseRFileStmt(Exp exp) {
        this.exp = exp;
    }


    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyDictionary<String, Value> symTable = state.getSymTable();
        Value val = exp.eval(symTable,state.getHeap());
        if (val.getType().equals(new StringType())) {
            IMyDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
            StringValue stringVal = (StringValue) val;
            if (fileTable.isDefined(stringVal)) {
                try {
                    BufferedReader bufferedReader = fileTable.lookup(stringVal);
                    bufferedReader.close();
                    fileTable.remove(stringVal);
                } catch (IOException e) {
                    throw new MyException(e.getMessage());
                }
            } else {
                throw new MyException("The file doesn't exist in the File Table!");
            }
        }
        else {
            throw new MyException("Expression could not be evaluated to a string in File Close!");
        }
        return null;
    }

    @Override
    public String toString() {
        return "close(" + exp + ")";
    }
}