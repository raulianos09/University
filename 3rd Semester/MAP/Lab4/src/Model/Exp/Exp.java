package Model.Exp;

import Exception.MyException;
import Model.ADT.IMyDictionary;
import Model.ADT.IMyHeap;
import Model.Value.Value;

public interface Exp {
    public Value eval(IMyDictionary<String,Value> tbl, IMyHeap<Value> heap) throws MyException;

}
