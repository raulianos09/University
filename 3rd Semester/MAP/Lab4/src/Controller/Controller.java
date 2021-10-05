package Controller;

import Exception.MyException;
import Model.ADT.IMyStack;
import Model.ADT.MyDictionary;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.Exp.AritmExp;
import Model.Exp.ValueExp;
import Model.Exp.VarExp;
import Model.PrgState;
import Model.Stmt.*;
import Model.Type.BoolType;
import Model.Type.IntType;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.RefValue;
import Model.Value.Value;
import Repo.IRepo;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    private IRepo repository;

    public Controller(IRepo repo) {
        this.repository = repo;
    }

    public PrgState oneStep(PrgState state) throws MyException{
        IMyStack<IStmt> stack = state.getStack();
        if (stack.isEmpty()) {
            throw new MyException("Stack is empty");
        }
        IStmt currentStmt = stack.pop();
        return currentStmt.execute(state);
    }

    public void allSteps() throws MyException, IOException {
        PrgState prg = repository.getCrtPrg();
        repository.printPrgState(prg);
        //System.out.println(prg);

        while (!prg.getStack().isEmpty()) {
            try {
                oneStep(prg);
                //System.out.println(prg);
                repository.printPrgState(prg);
                prg.getHeap().setContent(safeGarbageCollector(
                        getAddrFromSymTable(prg.getSymTable().getContent().values(),prg.getHeap().getContent().values()),
                        prg.getHeap().getContent()));
                //repository.printPrgState(prg);
            } catch (MyException exception) {
                throw new MyException(exception.getMessage());
            }
        }
    }

    public void example() {
        IMyStack<IStmt> stack = new MyStack<>();
        IStmt example_1 = new CompStmt(
                new VarDeclStmt("v", new IntType()),
                new CompStmt(
                        new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))
                )
        );

        IStmt example_2 = new CompStmt( new VarDeclStmt("a",new IntType()),
                new CompStmt(new VarDeclStmt("b",new IntType()),
                        new CompStmt(new AssignStmt("a",
                                new AritmExp(
                                        new ValueExp(new IntValue(2)),
                                        new AritmExp(
                                                new ValueExp(new IntValue(3)),
                                                new ValueExp(new IntValue(5)),'*'),'+')),
                                new CompStmt(new AssignStmt("b",
                                        new AritmExp( new VarExp("a"), new ValueExp(new IntValue(1)),'+')),
                                        new PrintStmt(new VarExp("b"))))));

        IStmt example_3 = new CompStmt(
                new VarDeclStmt("a" , new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(
                                new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("a"),
                                                new AssignStmt("v", new ValueExp(new IntValue(2))),
                                                new AssignStmt("v", new ValueExp(new IntValue(3)))
                                        ),
                                        new PrintStmt(new VarExp("v"))
                                )
                        )
                )
        );

        stack.push(example_2);
        PrgState state = new PrgState(stack, new MyDictionary<String, Value>(), new MyList<Value>());
        System.out.println(state);
        repository.addState(state);
    }

    Map<Integer, Value> safeGarbageCollector(List<Integer> addresses, Map<Integer, Value> heap) {
        return heap.entrySet().stream()
                .filter(elem -> addresses.contains(elem.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    List<Integer> getAddrFromSymTable(Collection<Value> symTableValues, Collection<Value> heap) {
        return Stream.concat(heap.stream()
                .filter(v->v instanceof RefValue)
                .map(v->{RefValue v1 = (RefValue) v; return v1.getAddress();}),
        symTableValues.stream()
                .filter(v -> v instanceof RefValue)
                .map(v->{RefValue v1 = (RefValue) v; return v1.getAddress();})).collect(Collectors.toList());
    }



}