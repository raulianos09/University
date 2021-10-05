package Model.Exp;

import Exception.MyException;
import Model.ADT.IMyDictionary;
import Model.ADT.IMyHeap;
import Model.Value.Value;

public class ValueExp implements Exp{

    Value e;

    public ValueExp(Value deepCopy) {
        e = deepCopy;
    }

    @Override
    public Value eval(IMyDictionary<String, Value> tbl, IMyHeap<Value> heap) throws MyException {
        return e;
    }

    @Override
    public String toString() {
        return e.toString();
    }
    
}
