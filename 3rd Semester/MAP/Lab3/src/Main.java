import Controller.Controller;
import Model.ADT.IMyStack;
import Model.ADT.MyDictionary;
import Model.ADT.MyList;
import Model.ADT.MyStack;
import Model.Exp.RelationalExp;
import Model.PrgState;
import Exception.MyException;
import Model.Exp.AritmExp;
import Model.Exp.ValueExp;
import Model.Exp.VarExp;
import Model.Stmt.*;
import Model.Type.*;
import Model.Value.*;
import Repo.IRepo;
import Repo.Repo;
import View.*;

import java.io.BufferedReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, MyException {
        IMyStack<IStmt> stack1 = new MyStack<>();
        IMyStack<IStmt> stack2 = new MyStack<>();
        IMyStack<IStmt> stack3 = new MyStack<>();
        IMyStack<IStmt> stack4 = new MyStack<>();

        IStmt example_1 = new CompStmt(
                new VarDeclStmt("x", new IntType()),
                new CompStmt(
                        new AssignStmt("x", new ValueExp(new IntValue(17))),
                        new PrintStmt(new VarExp("x"))
                )
        );

        PrgState prg1 = new PrgState(stack1, new MyDictionary<String, Value>(),  new MyList<Value>(), new MyDictionary<StringValue, BufferedReader>(), example_1);
        IRepo repo1 = new Repo(prg1, "log1.txt");
        Controller ctr1 = new Controller(repo1);

        IStmt example_2 = new CompStmt(
                new VarDeclStmt("x" , new IntType()),
                new CompStmt(new AssignStmt("x", new AritmExp(
                        new ValueExp(new IntValue(3)),
                        new AritmExp(
                                new ValueExp(new IntValue(5)), new ValueExp(new IntValue(7)), '*'
                        ),
                        '+'
                )
                ),
                        new PrintStmt(new VarExp("x"))
                )
        );
        PrgState prg2= new PrgState(stack2, new MyDictionary<String, Value>(),  new MyList<Value>(), new MyDictionary<StringValue, BufferedReader>(), example_2);
        IRepo repo2 = new Repo(prg2, "log2.txt");
        Controller ctr2 = new Controller(repo2);

        IStmt example_3 = new CompStmt(
                new VarDeclStmt("s" , new IntType()),
                new CompStmt(new VarDeclStmt("x", new IntType()),
                        new CompStmt(
                                new AssignStmt("s", new ValueExp(new IntValue(5))),
                                new CompStmt(
                                        new IfStmt(
                                                new RelationalExp(new VarExp("s"), new ValueExp( new IntValue(1)),1),
                                                new AssignStmt("x", new ValueExp(new IntValue(20))),
                                                new AssignStmt("x", new ValueExp(new IntValue(2)))
                                        ),
                                        new PrintStmt(new VarExp("x"))
                                )
                        )
                )
        );

        PrgState prg3 = new PrgState(stack3, new MyDictionary<String, Value>(),  new MyList<Value>(), new MyDictionary<StringValue, BufferedReader>(), example_3);
        IRepo repo3 = new Repo(prg3, "log3.txt");
        Controller ctr3 = new Controller(repo3);

        IStmt example_4 = new CompStmt(
                new VarDeclStmt("fileName", new StringType()),
                new CompStmt(new AssignStmt("fileName", new ValueExp(new StringValue("test.txt"))),
                        new CompStmt(new OpenRFileStmt(new VarExp("fileName")),
                                new CompStmt(new VarDeclStmt("x", new IntType()),
                                        new CompStmt(new ReadFileStmt(new VarExp("fileName"), "x"),
                                                new CompStmt(new PrintStmt(new VarExp("x")),
                                                        new CompStmt(new ReadFileStmt(new VarExp("fileName"), "x"),
                                                                new CompStmt(new PrintStmt(new VarExp("x")),
                                                                        new CloseRFileStmt(new VarExp("fileName"))))))))));

        PrgState prg4 = new PrgState(stack4, new MyDictionary<String, Value>(),  new MyList<Value>(), new MyDictionary<StringValue, BufferedReader>(), example_4);
        IRepo repo4 = new Repo(prg4, "log4.txt");
        Controller ctr4 = new Controller(repo4);
        TextMenu menu = new TextMenu();

        repo1.addState(prg1);
        repo2.addState(prg2);
        repo3.addState(prg3);
        repo4.addState(prg4);


        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",example_1.toString(),ctr1));
        menu.addCommand(new RunExample("2",example_2.toString(),ctr2));
        menu.addCommand(new RunExample("3",example_3.toString(),ctr3));
        menu.addCommand(new RunExample("4",example_4.toString(),ctr4));
        menu.show();
    }
}