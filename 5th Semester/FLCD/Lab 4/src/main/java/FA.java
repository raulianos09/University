
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FA {
    private final String inputFilePath = "src/main/resources/FA.in";
    private List<String> states;
    private List<String> alphabet;
    private String initialState;
    private List<String> finalStates;
    private int numberOfTransitions;
    private HashMap<ImmutablePair<String, String>, String> transitions;
    private boolean deterministic = true;

    public FA() {
        this.states = new ArrayList<>();
        this.finalStates = new ArrayList<>();
        this.transitions = new HashMap<>();
        this.alphabet = new ArrayList<>();
        readFA();
    }

    private void readFA() {
        try {
            File in = new File(this.inputFilePath);
            Scanner sc = new Scanner(in);

            //read the set of states
            String line = sc.nextLine();
            this.states.addAll(Arrays.asList(line.strip().split(" ")));

            //read the alphabet
            line = sc.nextLine();
            this.alphabet.addAll(Arrays.asList(line.strip().split(" ")));

            //read the number of transitions
            line = sc.nextLine();
            this.numberOfTransitions = Integer.parseInt(line.strip());

            //read the transitions
            for (int i = 0; i < this.numberOfTransitions; i++) {
                line = sc.nextLine();
                String[] tokensFromLine = line.strip().split(" ");
                ImmutablePair<String, String> transition = new ImmutablePair<>(tokensFromLine[0], tokensFromLine[1]);
                if (this.deterministic && this.transitions.containsKey(transition)) {
                    deterministic = false;
                }
                this.transitions.put(transition, tokensFromLine[2]);
            }

            //read the initial state
            line = sc.nextLine();
            this.initialState = line.strip();

            //read the set of final states
            line = sc.nextLine();
            this.finalStates.addAll(Arrays.asList(line.strip().split(" ")));

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void printStates() {
        System.out.println("The set of states of the finite automata is: ");
        System.out.println(this.states);
    }

    public void printAlphabet() {
        System.out.println("The alphabet of the finite automata is: ");
        System.out.println(this.alphabet);
    }

    public void printTransitions() {
        System.out.println("The list of transitions of the finite automata is: ");
        Set<ImmutablePair<String, String>> keySet = this.transitions.keySet();
        for (ImmutablePair<String, String> states : keySet) {
            System.out.println("State " + states.left + " ------ " + states.right + " ------> State " + this.transitions.get(states));
        }
    }

    public void printFinalStates() {
        System.out.println("The set of final states of the FA is: ");
        System.out.println(this.finalStates);
    }

    public void printInitialState() {
        System.out.println("The initial state of the FA is: " + this.initialState);
    }

    public boolean verifyDFA() {
        if (!this.deterministic) {
            throw new RuntimeException("The FA is NON-DETERMINISTIC!");
        }
        System.out.println("Enter the sequence to be checked: ");
        Scanner sc = new Scanner(System.in);
        char[] sequence = sc.nextLine().strip().toCharArray();
        String currentState = this.initialState;
        for (char c : sequence) {
            String path = String.valueOf(c);
            ImmutablePair<String, String> transition = new ImmutablePair<>(currentState, path);
            currentState = this.transitions.get(transition);
            if (currentState == null)
                return false;
        }
        return this.finalStates.contains(currentState);
    }

}
