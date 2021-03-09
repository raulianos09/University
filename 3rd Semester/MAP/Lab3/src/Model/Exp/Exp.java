package Model.Exp;

import Exception.MyException;
import Model.ADT.IMyDictionary;
import Model.Value.Value;

public interface Exp {
    public Value eval(IMyDictionary<String,Value> tbl) throws MyException;

}
