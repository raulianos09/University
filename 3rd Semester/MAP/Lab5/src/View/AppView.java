package View;

import Controller.Controller;
import Exception.MyException;
import Repo.IRepo;
import Repo.Repo;

import java.io.IOException;

public class AppView {
    Controller controller;

    public void printMenu() {
        System.out.println("****************\n");
        System.out.println("Example_1 = int x;  x=17;   print(x)\n");
        System.out.println("Example_2 = int x;  x=3+5*7;    print(x)\n");
        System.out.println("Example_3 = bool s; int x;  s=false;    if (s == true) then {x=20} else {x=2};  print(x)\n");
        System.out.println("****************\n");
    }

    public AppView() {
        IRepo repository = new Repo("log.txt");
        this.controller = new Controller(repository);
        printMenu();
        try {
            controller.example();
            controller.allSteps();
        } catch (MyException | IOException| InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}