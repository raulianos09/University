package Model.Exp;

import Exception.MyException;
import Model.ADT.IMyDictionary;
import Model.Value.BoolValue;
import Model.Value.Value;
import Model.Type.BoolType;

public class LogicExp implements Exp{
    Exp e1;
    Exp e2;
    int op;

    public LogicExp(Exp deepCopy, Exp deepCopy1, int op1) {
        e1 = deepCopy;
        e2 = deepCopy1;
        op = op1;
    }

    @Override
    public Value eval(IMyDictionary<String, Value> tbl) throws MyException {
        Value val1, val2;
        val1 = e1.eval(tbl);
        if (val1.getType().equals(new BoolType())) {
            val2 = e2.eval(tbl);
            if (val2.getType().equals(new BoolType())) {
                BoolValue i1 = (BoolValue)val1;
                BoolValue i2 = (BoolValue)val2;
                boolean x = i1.getValue();
                boolean y = i2.getValue();
                if (op == 1) {
                    return new BoolValue(x && y);
                }
                else if (op == 2) {
                    return new BoolValue(x || y);
                }
            }
            else {
                throw new MyException("Second operand is not a boolean");
            }
        }
        else {
            throw new MyException("First operand is not a boolean");
        }

        return new BoolValue(false);
    }
}
