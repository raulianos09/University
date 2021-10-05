package Model.Stmt;

import Model.ADT.IMyDictionary;
import Model.ADT.IMyHeap;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;
import Exception.MyException;

public class WriteHeapStmt implements IStmt{

    private String variableName;
    private Exp exp;

    public WriteHeapStmt(String variableName, Exp exp) {
        this.variableName = variableName;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyDictionary<String, Value> symTable = state.getSymTable();
        IMyHeap<Value> heap = state.getHeap();

        if (symTable.isDefined(variableName)) {
            if (symTable.lookup(variableName).getType() instanceof RefType) {
                RefValue refVal = (RefValue) symTable.lookup(variableName);
                if (heap.contains(refVal.getAddress())) {
                    Value val = exp.eval(symTable, heap);
                    if (symTable.lookup(variableName).getType().equals(new RefType(val.getType()))) {
                        int address = refVal.getAddress();
                        heap.update(address, val);
                    }
                    else {
                        throw new MyException("The pointing variable has a different type than the evaluated expression.");
                    }
                }
                else {
                    throw new MyException("The address to which " + variableName + " points is not in the heap");
                }
            }
            else {
                throw new MyException(variableName + " is not a reference variable");
            }
        }
        else {
            throw new MyException(variableName + " is not defined");
        }

        return null;
    }

    
    @Override
    public String toString() {
        return "wH(" + variableName + "," + exp + ")";
    }
    
}
