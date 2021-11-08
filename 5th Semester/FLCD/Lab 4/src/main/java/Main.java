import java.util.Scanner;

public class Main {
    public static final void main(String[] args) {
        FA finiteAutomata = new FA();

        System.out.println("Welcome!\nType 'help' as input in case you need help.");
        Scanner sc = new Scanner(System.in);

        while (true) {
            String option = sc.nextLine();
            option = option.strip();

            switch (option) {
                case "0":
                    System.exit(0);
                    break;

                case "1":
                    finiteAutomata.printStates();
                    break;

                case "2":
                    finiteAutomata.printAlphabet();
                    break;

                case "3":
                    finiteAutomata.printTransitions();
                    break;

                case "4":
                    finiteAutomata.printInitialState();
                    break;

                case "5":
                    finiteAutomata.printFinalStates();
                    break;

                case "6":
                    try {
                        boolean response = finiteAutomata.verifyDFA();
                        if (response) {
                            System.out.println("The sequence is accepted by the FA!");
                        } else {
                            System.out.println("The sequence is NOT accepted by the FA!");
                        }
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "help":
                    printMenu();
                    break;

                default:
                    System.out.println("Please try again! The given option is invalid!");
                    break;
            }
        }
    }

    private static void printMenu() {
        String menu = "These are the available options: " + "\n" +
                "1. Print the set of states of the FA" + "\n" +
                "2. Print the alphabet of the FA" + "\n" +
                "3. Print the set of transitions of the FA" + "\n" +
                "4. Print the initial state of the FA" + "\n" +
                "5. Print the set of final states of the FA" + "\n" +
                "6. Verify sequence" +
                "0. Exit the program";

        System.out.println(menu);
    }
}
