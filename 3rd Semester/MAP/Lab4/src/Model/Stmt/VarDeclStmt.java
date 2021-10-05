package Model.Stmt;

import Exception.MyException;
import Model.ADT.IMyDictionary;
import Model.ADT.IMyStack;
import Model.PrgState;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Type.StringType;
import Model.Type.Type;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Model.Value.Value;

public class VarDeclStmt implements IStmt{
    String name;
    Type type;

    public VarDeclStmt(String s, Type deepCopy) {
        name = s;
        type = deepCopy;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyStack<IStmt> stack = state.getStack();
        IMyDictionary<String, Value> table = state.getSymTable();
        if (table.isDefined(name)) {
            throw new MyException("Variable is already declared");
        } else {
/*            if (type.equals(new IntType())) {
                table.add(name, new IntValue());
            }else if (type.equals(new BoolType())) {
                table.add(name, new BoolValue());
            }else if (type.equals(new StringType())) {
                table.add(name, new StringValue());
            }else {
                throw new MyException("Type does not exist");
            }*/
            table.add(name, type.defaultValue());
        }
        state.setSymTable(table);
        state.setExeStack(stack);
        return state;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }
}
