package Model.Stmt;

import Model.ADT.IMyDictionary;
import Model.ADT.IMyHeap;
import Model.ADT.IMyStack;
import Model.Exp.Exp;
import Model.PrgState;
import Model.Type.RefType;
import Model.Value.RefValue;
import Model.Value.Value;
import Exception.MyException;

public class NewHeapStmt implements IStmt{

    String var_name;
    Exp exp;

    public NewHeapStmt(String var_name, Exp exp) {
        this.var_name = var_name;
        this.exp = exp;
    }



    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyStack<IStmt> stack = state.getStack();
        IMyDictionary<String, Value> symTbl = state.getSymTable();
        IMyHeap<Value> heap = state.getHeap();
        if(symTbl.isDefined(var_name)){
            if(symTbl.lookup(var_name).getType() instanceof RefType){
                Value val = exp.eval(symTbl, heap);
                Value tblVal = symTbl.lookup(var_name);
                if(val.getType().equals(((RefType)(tblVal.getType())).getInner())){
                    int addr = heap.allocate(val);
                    symTbl.update(var_name, new RefValue(val.getType(), addr));
                }
                else{
                    throw new MyException("Value's type is not correct!");
                }
            }
            else{
                throw new MyException("Value's type is not reference!");
            }
        }
        else{
            throw new MyException("Value is not declared!");
        }
        state.setSymTable(symTbl);
        state.setHeap(heap);
        state.setExeStack(stack);
        return state;
    }

    @Override
    public String toString(){
        return "new(" + var_name + ", " + exp + ")";
    }

}
