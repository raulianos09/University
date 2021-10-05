package Model.Stmt;

import Model.ADT.IMyDictionary;
import Model.PrgState;
import Exception.MyException;
import Model.Exp.Exp;
import Model.Type.IntType;
import Model.Type.StringType;
import Model.Value.IntValue;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileStmt implements IStmt {
    private Exp exp;
    private String varName;
    private String fileName;

    public ReadFileStmt(Exp expression, String varName) {
        this.exp = expression;
        this.varName = varName;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        IMyDictionary<String, Value> symTable = state.getSymTable();
        IMyDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();

        if (symTable.isDefined(varName)) {
            if (symTable.lookup(varName).getType().equals(new IntType())) {
                Value val = exp.eval(symTable, state.getHeap());
                if (val.getType().equals(new StringType())) {
                    StringValue stringVal = (StringValue) val;
                    if (fileTable.isDefined(stringVal)) {
                        BufferedReader bufferedReader = fileTable.lookup(stringVal);
                        try {
                            String line = bufferedReader.readLine();
                            Value intVal;
                            IntType type = new IntType();
                            if (line == null) {
                                intVal = type.defaultValue();
                            } else if ( ! line.chars().allMatch(Character::isDigit) )
                            {
                                throw new MyException("Given type is not supported by file operation!");
                            }
                                else {
                                intVal = new IntValue(Integer.parseInt(line));
                            }
                            symTable.update(varName, intVal);
                        } catch (IOException e) {
                            throw new MyException(e.getMessage());
                        }
                    }
                    else {
                        throw new MyException("The file " + stringVal.getValue() + " is not in the File Table!");
                    }
                }
                else {
                    throw new MyException("The value couldn't be evaluated to a string value!");
                }
            }
            else {
                throw new MyException(varName + " is not of type int!");
            }
        }
        else {
            throw new MyException(varName + " is not defined in Sym Table");
        }

        return null;
    }


    @Override
    public String toString() {
        return "Read From " + exp + " into " + varName;
    }
    
}