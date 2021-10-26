package Scanner;

import HashMap.Pair;
import PIF.PIF;
import ST.SymbolTable;

import java.io.*;
import java.util.List;

public class Scanner {
    private final File file;
    private SymbolTable st;
    private PIF pif;

    private List<String> reservedWords = List.of("iterate", "check", "read", "let", "int", "write", "save", "boolean", "string");
    private List<String> separators = List.of(":", ";", "[", "]", "{", "}", "(", ")", "\n", "\t", " ");
    private List<String> operators = List.of("+", "-", "*", "/", ":=", "=", "!=", "<", ">", "<=", ">=");


    public Scanner(File fileToScan, SymbolTable st, PIF pif) {
        this.file = fileToScan;
        this.st = st;
        this.pif = pif;
    }

    private boolean checkIfIdentifier(String token) {
        return token.matches("^[a-zA-Z]*$");
    }

    private boolean checkIfInt(String token) {
        return token.matches("^([+-]?[1-9][0-9]*)|[+-]?0$");
    }

    private boolean checkIfBool(String token) {
        return token.matches("^true|false$");
    }

    private boolean checkIfString(String token) {
        return token.matches("^\"[a-zA-Z0-9 ]*\"$");
    }

    private boolean checkIfConstant(String token) {
        return checkIfBool(token) || checkIfInt(token) || checkIfString(token);
    }

    public void run() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file.getPath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        while ((line = reader.readLine()) != null) {
            try {
                System.out.println(line);
                getTokensFromLine(line);
            }
            catch (RuntimeException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void getTokensFromLine(String line) {
        String[] tokens = line.split(" ");
        for(String token : tokens) {
            if(separators.contains(token) || operators.contains(token) || reservedWords.contains(token))
            {
                pif.add(token, new Pair<>(-1,-1));
                System.out.println(token + " is operator||separator||reservedWord");
            }
            else
                if( checkIfIdentifier(token) || checkIfConstant(token))
                {
                    Pair <Integer, Integer> tokenPositionInST;
                    tokenPositionInST = st.add(token);
                    pif.add(token, tokenPositionInST);
                    System.out.println(token);
                }
                else
                    throw new RuntimeException("Lexical Error");
        }


    }


}
