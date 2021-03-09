package View;

import Controller.*;
import Model.*;
import java.util.Scanner;


public class View {
    Controller controller;
    Scanner cin;

    public View(Controller controller) {
        this.controller = controller;
        this.cin = new Scanner(System.in);
    }

    public void run() {
        int userInput;

        while (true) {
            MainMenu();
            userInput = readInput();
            switch(userInput) {
                case 1:     
                    IVehicle newVehicle;
                    AddMenu();
                    userInput = readInput();
                    try {
                        if (userInput == 1)
                        {newVehicle = readCar();
                        controller.add(newVehicle);}
                        else if (userInput == 2)
                        {newVehicle = readBicycle();
                            controller.add(newVehicle);}
                        else if (userInput == 3)
                        {newVehicle = readMotorcycle();
                            controller.add(newVehicle);}
                        else
                            break;
                    }
                    catch (Exception e) {
                    System.out.println(e);
                    }

                    break;

                case 2:    
                    int id;
                    RemoveMenu();
                    userInput = readInput();
                    System.out.print("id = ");
                    while (!cin.hasNextInt()) {
                        cin.next();
                        System.out.println("Wrong input! Please enter an integer.");
                    }
                    id = cin.nextInt();
                    try {
                        switch (userInput){
                        case 1:
                            controller.remove(new Car(id, ""));
                            break;
                        case 2:
                            controller.remove(new Bicycle(id, ""));
                            break;
                        case 3:
                            controller.remove(new Motorcycle(id, ""));
                            break;
                        default:
                            break;
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:     // show all red  vehicles
                    IVehicle[] redVehicles = controller.solve();
                    for (IVehicle redVehicle : redVehicles) {
                        System.out.println(redVehicle);
                    }
                    break;
                case 0:
                    System.out.println("Program closed successfully!");
                    return;
                default:
                    break;
            }
        }
    }

    private int readInput() {
        int userInput;

        while (true) {
            while (!cin.hasNextInt()) {
                cin.next();
                System.out.println("Wrong input! Please enter an integer.");
            }
            userInput = cin.nextInt();
            cin.nextLine();
            if (0 <= userInput && userInput <= 3)
                break;
            System.out.println("Wrong input! No such option.");
        }
        return userInput;
    }

    private void MainMenu() {
        System.out.println("----What's next?----");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("3. Show all red vehicles");
        System.out.println("0. Exit");
    }

    private void AddMenu() {
        System.out.println("---What to add?...");
        System.out.println("1. A Car");
        System.out.println("2. A Bicycle");
        System.out.println("3. A Motorcycle");
        System.out.println("0. Go back to main menu");
    }

    private void RemoveMenu() {
        System.out.println("---What to remove?...");
        System.out.println("1. A Car");
        System.out.println("2. A Bicycle");
        System.out.println("3. A Motorcycle");
        System.out.println("0. Go back to main menu");
    }

    private Car readCar() throws Exception{
        Car Car;
        int id;
        String color;

        System.out.print("Car id = ");
        while (!cin.hasNextInt()) {
            cin.next();
            System.out.println("Wrong input! Please enter an integer.");
        }
        id = cin.nextInt();
        cin.nextLine();

        System.out.print("Car color = ");
        color = cin.nextLine();

        if(color.equals(""))
            throw new Exception("Color must be a non empty string!");

        Car = new Car(id, color);
        return Car;
    }

    private Bicycle readBicycle() throws Exception{
        Bicycle Bicycle;
        int id;
        String color;

        System.out.print("Bicycle id = ");
        while (!cin.hasNextInt()) {
            cin.next();
            System.out.println("Wrong input! Please enter an integer.");
        }
        id = cin.nextInt();
        cin.nextLine();

        System.out.print("Bicycle color = ");
        color = cin.nextLine();

        if(color.equals(""))
            throw new Exception("Color must be a non empty string!");

        Bicycle = new Bicycle(id,color);
        return Bicycle;
    }

    private Motorcycle readMotorcycle() throws Exception{
        Motorcycle Motorcycle;
        int id;
        String color;

        System.out.print("Motorcycle id = ");
        while (!cin.hasNextInt()) {
            cin.next();
            System.out.println("Wrong input! Please enter an integer.");
        }
        id = cin.nextInt();
        cin.nextLine();

        System.out.print("Motorcycle color = ");
        color = cin.nextLine();

        if(color.equals(""))
            throw new Exception("Color must be a non empty string!");

        Motorcycle = new Motorcycle(id, color);
        return Motorcycle;
    }
}