import Polynomial.Polynomial;
import java.util.concurrent.ExecutionException;


import static Polynomial.Operations.*;

public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(10);
        Polynomial p2 = new Polynomial(10);

        p1.generateRandom();
        p2.generateRandom();

        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);

        System.out.println("\n");

        // normal algo
        Long start = System.nanoTime();
        System.out.println("R: " + normalSequentialMultiplication(p1,p2));
        Long end = System.nanoTime();
        System.out.println("Result computed seq with regular algorithm took " + (end - start) + " nanoseconds\n");

        start = System.nanoTime();
        System.out.println("R: " + normalParallelMultiplication(p1,p2));
        end = System.nanoTime();
        System.out.println("Result computed par with normal algorithm took " + (end - start) + " nanoseconds\n");



        // karatsuba algo
        start = System.nanoTime();
        System.out.println("R: " + karatsubaSequentialMultiplication(p1,p2));
        end = System.nanoTime();
        System.out.println("Result computed seq with karatsuba algorithm took " + (end - start) + " nanoseconds\n");

        start = System.nanoTime();
        try {
            System.out.println("R: " + karatsubaParallelMultiplication(p1,p2));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        end = System.nanoTime();
        System.out.println("Result computed par with karatsuba algorithm took " + (end - start) + " nanoseconds\n");

    }
}
