package Model.Exp;

import Exception.MyException;
import Model.ADT.IMyDictionary;
import Model.Value.Value;

public class VarExp implements Exp{
    
    String id;

    public VarExp(String s) {
        id = s;
    }

    @Override
    public Value eval(IMyDictionary<String, Value> tbl) throws MyException {
        return tbl.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }
    
}
