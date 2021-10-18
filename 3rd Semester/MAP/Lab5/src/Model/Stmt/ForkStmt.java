package Model.Stmt;



import Model.ADT.*;
import Model.PrgState;
import Exception.MyException;
import Model.Value.StringValue;
import Model.Value.Value;


import java.io.BufferedReader;
import java.util.Map;

public class ForkStmt implements IStmt{
    private IStmt statement;

    public ForkStmt(IStmt statement) {
        this.statement = statement;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyStack<IStmt> stk = state.getStack();
        IMyDictionary<String, Value> symTable = state.getSymTable();
        IMyHeap<Value> heap = state.getHeap();
        IMyList<Value> outList = state.getOutConsole();
        IMyDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();

        MyStack<IStmt> newStk = new MyStack<IStmt>();
        MyDictionary<String, Value> newSymTable = new MyDictionary<String, Value>();
        for (Map.Entry<String, Value> entry: symTable.getContent().entrySet()) {
            newSymTable.update(new String(entry.getKey()), entry.getValue());
        }
        return new PrgState(newStk, newSymTable, outList, fileTable, heap, statement);
    }

    @Override
    public String toString() {
        return "fork(" + statement + ")";
    }
}