import PIF.PIF;
import ST.SymbolTable;
import Scanner.Scanner;

import java.io.*;

public class Main {
    public static void main(String[] args){
        SymbolTable st = new SymbolTable();
        PIF pif = new PIF();
        File file = new File("src/main/resources/p1.txt");
        Scanner scanner = new Scanner(file,st,pif);
        try {
            scanner.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File pifFile = new File("src/main/resources/pif.txt");
        try {
            BufferedWriter pifWriter = new BufferedWriter(new FileWriter(pifFile));
            pifWriter.write(pif.toString());
            pifWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        File StFile = new File("src/main/resources/ST.txt");
        try {
            BufferedWriter STWriter = new BufferedWriter(new FileWriter(StFile));
            STWriter.write(st.toString());
            STWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}