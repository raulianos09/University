package View;

import Controller.Controller;
import Exception.MyException;

import java.io.IOException;

public class RunExample extends Command {
    private Controller controller;

    public RunExample(String key, String description, Controller controller) {
        super(key, description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try {
            controller.allSteps();
        }
        catch (MyException | IOException e) {
            System.out.println(e.toString());
        }
    }
}