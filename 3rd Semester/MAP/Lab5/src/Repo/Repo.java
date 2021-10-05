package Repo;

import Model.PrgState;
import Model.Stmt.IStmt;
import Exception.MyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Repo implements IRepo{

    private List<PrgState> states;
    private IStmt originalProgram;
    private String fileName;

    public Repo(PrgState prgState, String fileName) throws MyException, IOException {
        //this.originalProgram = prgState.getOriginalProgram();
        this.fileName = fileName;
        File yourFile = new File(fileName);
        yourFile.createNewFile();
        try (FileWriter fileWriter = new FileWriter(yourFile)) {
            fileWriter.write("");
        }
        catch (IOException e) {
            throw new MyException(e.getMessage());
        }
        states = new LinkedList<>();
    }

    public Repo() {
        states = new LinkedList<>();
    }

    public Repo(String givenFile) {
        this.fileName = givenFile;
        states = new LinkedList<>();
    }
    @Override
    public List<PrgState> getPrgList() {
        return states;
    }


    @Override
    public PrgState getCrtPrg() {
        PrgState state =  states.get(0);
        states.remove(0);
        return state;
    }

    @Override
    public void setPrgList(List<PrgState> list) {
        states = list;
    }

    @Override
    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    @Override
    public void printPrgState(PrgState prgState) throws MyException, IOException {
        File yourFile = new File(fileName);
        yourFile.createNewFile();
        try (FileWriter fileWriter = new FileWriter(yourFile, true)) {
            fileWriter.write(prgState + "\n");
            fileWriter.close();
        }
        catch (IOException e) {
            throw new MyException(e.getMessage());
        }
    }

    @Override
    public void addState(PrgState state) {
        states.add(state);
    }
}
