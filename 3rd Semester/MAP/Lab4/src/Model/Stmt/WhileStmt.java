package Model.Stmt;

import Model.ADT.IMyDictionary;
import Model.ADT.IMyStack;
import Model.Exp.Exp;
import Model.PrgState;
import Exception.MyException;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Model.Value.Value;

public class WhileStmt implements IStmt{

    private Exp exp;
    private IStmt statement;

    public WhileStmt(Exp exp, IStmt statement) {
        this.exp = exp;
        this.statement = statement;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyStack<IStmt> stk = state.getStack();
        IMyDictionary<String, Value> symTable = state.getSymTable();
        Value val = exp.eval(symTable, state.getHeap());
        if (val.getType().equals(new BoolType())) {
            BoolValue boolVal = (BoolValue) val;
            if (boolVal.getValue()) {
                stk.push(this);
                stk.push(statement);
            }
        }
        else {
            throw new MyException("The While condition is not a boolean");
        }
        return null;
    }


    @Override
    public String toString() {
        return "(while (" + exp + ") " + statement + ")";
    }

}
