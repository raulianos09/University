package Model.Stmt;

import Exception.MyException;
import Model.ADT.IMyList;
import Model.ADT.IMyStack;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Value.Value;

public class PrintStmt implements IStmt{
    Exp exp;

    public PrintStmt(Exp deepCopy) {
        exp = deepCopy;
    }

    @Override
    public String toString(){
        return "print(" + exp.toString() +")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyStack<IStmt> stack = state.getStack();
        IMyList<Value> outConsole = state.getOutConsole();
        outConsole.add(exp.eval(state.getSymTable(),state.getHeap()));
        state.setExeStack(stack);
        state.setOutConsole(outConsole);
        return state;
    }
}
