package Polynomial;

import ClassicMultiplication.ParMultiplier;
import ClassicMultiplication.SeqMultiplier;
import KaratsubaMultiplication.ParKaratsuba;
import KaratsubaMultiplication.SeqKaratsuba;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Operations {

    public static Polynomial normalSequentialMultiplication(Polynomial p1, Polynomial p2){
        return SeqMultiplier.multiply(p1, p2);
    }

    public static Polynomial normalParallelMultiplication(Polynomial p1, Polynomial p2)
    {
        int NUMBER_OF_THREADS = 10;

        Polynomial rParNormal = new Polynomial(p1.getDegree() + p2.getDegree() - 1);

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Runnable> runnables = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Runnable t = new ParMultiplier(p1, p2, rParNormal, NUMBER_OF_THREADS, i);
            runnables.add(t);
        }
        for (Runnable r : runnables) {
            threadPoolExecutor.submit(r);
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {

        }
        return rParNormal;
    }

    public static Polynomial karatsubaSequentialMultiplication(Polynomial p1, Polynomial p2)
    {
       return SeqKaratsuba.multiply(p1,p2);
    }

    public static Polynomial karatsubaParallelMultiplication(Polynomial p1, Polynomial p2) throws ExecutionException, InterruptedException {
        return ParKaratsuba.multiply(p1,p2,0);
    }

    public static Polynomial shiftPolynomial(Polynomial p, int offset) {
        List<Integer> coefficients = new ArrayList<>();
        for (int i = 0; i < offset; i++) {
            coefficients.add(0);
        }
        coefficients.addAll(p.getCoefficients());
        return new Polynomial(coefficients);
    }

    public static Polynomial addPolynomials(Polynomial p1, Polynomial p2) {
        int minDegree = Math.min(p1.getDegree(), p2.getDegree());
        int maxDegree = Math.max(p1.getDegree(), p2.getDegree());
        List<Integer> coefficients = new ArrayList<>(maxDegree + 1);
        for (int i = 0; i < minDegree; i++) {
            coefficients.add(p1.getCoefficient(i) + p2.getCoefficient(i));
        }
        if (minDegree != maxDegree) {
            if (maxDegree == p1.getDegree()) {
                for (int i = minDegree ; i < maxDegree; i++) {
                    coefficients.add(p1.getCoefficient(i));
                }
            } else {
                for (int i = minDegree; i < maxDegree; i++) {
                    coefficients.add(p2.getCoefficient(i));
                }
            }
        }
        return new Polynomial(coefficients);
    }

    public static Polynomial subtractPolynomial(Polynomial p1, Polynomial p2) {
        int minDegree = Math.min(p1.getDegree(), p2.getDegree());
        int maxDegree = Math.max(p1.getDegree(), p2.getDegree());
        List<Integer> coefficients = new ArrayList<>(maxDegree + 1);
        for (int i = 0; i < minDegree; i++) {
            coefficients.add(p1.getCoefficient(i) - p2.getCoefficient(i));
        }
        if (minDegree != maxDegree) {
            if (maxDegree == p1.getDegree()) {
                for (int i = minDegree ; i < maxDegree; i++) {
                    coefficients.add(p1.getCoefficient(i));
                }
            } else {
                for (int i = minDegree ; i < maxDegree; i++) {
                    coefficients.add(p1.getCoefficient(i));
                }
            }
        }
        int i = coefficients.size() - 1;
        while (coefficients.get(i) == 0 && i > 0) {
            coefficients.remove(i);
            i--;
        }

        return new Polynomial(coefficients);
    }
}
