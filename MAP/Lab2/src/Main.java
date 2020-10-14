import Model.*;
import Repository.*;
import Controller.*;
import View.*;

public class Main {
    static int repository_capacity = 1;

    public static void main(String[] args) {
        IRepository repo = new InMemoryRepo(repository_capacity);
        Controller  controller = new Controller(repo);
        View        ui   = new View(controller);

        try {
            controller.add(new Bicycle(1, "Red"));
            controller.add(new Bicycle(2, "Blue"));
            controller.add(new Motorcycle(3, "Red"));
            controller.add(new Motorcycle(4, "Blue"));
            controller.add(new Car(5, "Red"));
            controller.add(new Car(6, "Blue"));

            ui.run();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}