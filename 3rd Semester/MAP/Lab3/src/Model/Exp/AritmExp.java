package Model.Exp;

import Exception.MyException;
import Model.ADT.IMyDictionary;
import Model.Value.IntValue;
import Model.Value.Value;
import Model.Type.IntType;


public class AritmExp implements Exp {
    Exp e1;
    Exp e2;
    int op; //1-plus, 2-minus, 3-star, 4-divide


    public AritmExp(Exp deepCopy, Exp deepCopy1, char op) {
        this.e1 = deepCopy;
        this.e2 = deepCopy1;
        if(op == '+')
            this.op = 1;
        if(op == '-')
            this.op = 2;
        if(op == '*')
            this.op = 3;
        if(op == '/')
            this.op = 4;
    }

    @Override
    public Value eval(IMyDictionary<String, Value> tbl) throws MyException {
        Value val1, val2;
        val1 = e1.eval(tbl);
        if (val1.getType().equals(new IntType())) {
            val2 = e2.eval(tbl);
            if (val2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue)val1;
                IntValue i2 = (IntValue)val2;
                int n1 = i1.getValue();
                int n2 = i2.getValue();
                switch (op) {
                    case 1:
                        return new IntValue(n1 + n2);
                    case 2:
                        return new IntValue(n1 - n2);
                    case 3:
                        return new IntValue(n1 * n2);
                    case 4:
                        if (n2 == 0) {
                            throw new MyException("Division by zero");
                        }
                        else {
                            return new IntValue(n1 / n2);
                        }
                    default:
                        throw new MyException("Incorrect operation");
                }
            }
            else {
                throw new MyException("Second operand is not an integer");
            }
        }
        else {
            throw new MyException("First operand is not an integer");
        }

    }



    @Override
    public String toString() {
        switch (op) {
            case 1:
                return e1.toString() + "+" + e2.toString();
            case 2:
                return e1.toString() + "-" + e2.toString();
            case 3:
                return e1.toString() + "*" + e2.toString();
            case 4:
                return e1.toString() + '/' + e2.toString();
            default:
                return "";
        }
    }
}