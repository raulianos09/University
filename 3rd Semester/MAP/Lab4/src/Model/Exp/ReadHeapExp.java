package Model.Exp;

import Model.ADT.IMyDictionary;
import Model.ADT.IMyHeap;
import Model.Value.RefValue;
import Model.Value.Value;
import Exception.MyException;

public class ReadHeapExp implements Exp{

    private Exp exp;

    public ReadHeapExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public Value eval(IMyDictionary<String, Value> symTable, IMyHeap<Value> heap) throws MyException {
        Value val = exp.eval(symTable, heap);
        if (val instanceof RefValue) {
            RefValue refVal = (RefValue) val;
            if (heap.contains(refVal.getAddress())) {
                return heap.get(refVal.getAddress());
            } else {
                throw new MyException("The address doesn't exist in the heap");
            }

        } else {
            throw new MyException("The expression could not be evaluated to a RefValue");
        }
    }


    @Override
    public String toString() {
        return "rH(" + exp + ")";
    }

}
