package Model.Stmt;

import Model.ADT.IMyStack;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Type.BoolType;
import Model.Value.BoolValue;
import Model.Value.Value;
import Exception.MyException;

public class IfStmt implements IStmt{
    private Exp expression;
    private IStmt thenStatement;
    private IStmt elseStatement;

    public IfStmt(Exp e, IStmt t, IStmt el) {
        expression = e;
        thenStatement = t;
        elseStatement = el;

    }

    @Override
    public String toString() {
        return "if (" + expression + ") then {" + thenStatement + "} else {" + elseStatement + "}";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyStack<IStmt> stack = state.getStack();
        Value cond = expression.eval(state.getSymTable(),state.getHeap());
        if (!cond.getType().equals(new BoolType())) {
            throw new MyException("Condition is not of type: boolean");
        }
        if (cond.equals(new BoolValue(true))) {
            stack.push(thenStatement);
        } else {
            stack.push(elseStatement);
        }
        state.setExeStack(stack);
        return state;
    }
}
