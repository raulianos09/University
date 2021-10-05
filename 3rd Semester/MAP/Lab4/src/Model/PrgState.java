package Model;

import Model.ADT.*;
import Model.Stmt.IStmt;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;

public class PrgState {
    private IMyStack<IStmt> exeStack;
    private IMyDictionary<String, Value> symTable;
    private IMyList<Value> out;
    private IMyDictionary<StringValue, BufferedReader> fileTable;
    //private IStmt originalProgram; //optional field, but good to have
    private IMyHeap<Value> heap;

    public PrgState(IMyStack<IStmt> stk, IMyDictionary<String, Value> symtbl, IMyList<Value> ot, IMyDictionary<StringValue, BufferedReader> fT, IMyHeap<Value> givenHeap, IStmt prg) {
        exeStack = stk;
        symTable = symtbl;
        out = ot;
        fileTable = fT;
        //originalProgram = prg;
        heap = givenHeap;
        stk.push(prg);
    }

    public PrgState(IMyStack<IStmt> stack, IMyDictionary<String, Value> stringValueMyDictionary, IMyList<Value> valueMyList) {
        exeStack = stack;
        symTable = stringValueMyDictionary;
        out = valueMyList;
        heap = new MyHeap<Value>();
    }

    public IMyStack<IStmt> getStack() {
        return exeStack;
    }

    public IMyDictionary<String, Value> getSymTable() {
        return symTable;
    }

    /*public IStmt getOriginalProgram(){
        return originalProgram;
    }
    */
    public IMyDictionary<StringValue, BufferedReader> getFileTable() {
        return fileTable;
    }

    public IMyHeap<Value> getHeap(){return heap;}

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Program state\n");
        str.append("Exe Stack: ").append(exeStack).append(" \n");
        str.append("Sym Table: ").append(symTable).append(" \n");
        str.append("Heap: ").append(heap).append(" \n");
        str.append("Output Console: ").append(out).append(" \n");
        str.append("File Table: ").append(fileTable).append(" \n");
        return str.toString();
    }

    public void setExeStack(IMyStack<IStmt> stack) {
        exeStack = stack;
    }

    public void setSymTable(IMyDictionary<String, Value> table) {
        symTable = table;
    }

    public void setHeap(IMyHeap<Value> givenHeap) {
        heap = givenHeap;
    }

    public IMyList<Value> getOutConsole() {
        return out;
    }

    public void setOutConsole(IMyList<Value> outConsole) {
        out = outConsole;
    }
}
