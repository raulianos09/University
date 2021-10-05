package Model.Stmt;

import Model.ADT.IMyDictionary;
import Model.PrgState;
import Exception.MyException;
import Model.Exp.Exp;
import Model.Type.StringType;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class OpenRFileStmt implements IStmt {
    private Exp exp;

    public OpenRFileStmt(Exp exp) {
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException{
        IMyDictionary<String, Value> symTable = state.getSymTable();
        Value val = exp.eval(symTable, state.getHeap());
        if (val.getType().equals(new StringType())) {
            IMyDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
            StringValue stringVal = (StringValue) val;
            if (!fileTable.isDefined(stringVal)) {
                try {
                    Reader reader = new FileReader(stringVal.getValue());
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    fileTable.update(stringVal, bufferedReader);
                }
                catch (FileNotFoundException e) {
                    throw new MyException(e.getMessage());
                }
            }
            else {
                throw new MyException("The file is already in use!");
            }
        }
        else {
            throw new MyException("Expression couldn't be evaluated to a string value in File Open!");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Open(" + exp + ")";
    }
    
}