package KaratsubaMultiplication;

import ClassicMultiplication.SeqMultiplier;
import Polynomial.Polynomial;

import java.util.concurrent.*;

import static Polynomial.Operations.*;

public class ParKaratsuba {
    public static Polynomial multiply(Polynomial p1, Polynomial p2, int depth) throws ExecutionException, InterruptedException {
        if (depth > 10)
            return SeqMultiplier.multiply(p1, p2);

        if (p1.getDegree() < 2 || p2.getDegree() < 2)
            return SeqMultiplier.multiply(p1, p2);

        int len = Math.max(p1.getDegree(), p2.getDegree()) / 2;
        Polynomial lowFirst = new Polynomial(p1.getCoefficients().subList(0, len));
        Polynomial highFirst = new Polynomial(p1.getCoefficients().subList(len, p1.getDegree()));

        Polynomial lowSecond = new Polynomial(p2.getCoefficients().subList(0, len));
        Polynomial highSecond = new Polynomial(p2.getCoefficients().subList(len, p2.getDegree()));

        Polynomial rParNormal = new Polynomial(p1.getDegree() + p2.getDegree() - 1);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        Callable<Polynomial> task1 = () -> multiply(highFirst, highSecond, depth + 1);
        Callable<Polynomial> task2 = () -> multiply(lowFirst, lowSecond, depth + 1);
        Callable<Polynomial> task3 = () -> multiply(addPolynomials(lowFirst, highFirst), addPolynomials(lowSecond, highSecond), depth + 1);


        Future<Polynomial> f1 = executor.submit(task1);
        Future<Polynomial> f2 = executor.submit(task2);
        Future<Polynomial> f3 = executor.submit(task3);

        executor.shutdown();

        Polynomial z1 = f1.get();
        Polynomial z2 = f2.get();
        Polynomial z3 = subtractPolynomial(subtractPolynomial(f3.get(), z1), z2);

        while (!executor.isTerminated()) {

        }

        return addPolynomials(z2, addPolynomials(shiftPolynomial(z1, len * 2), shiftPolynomial(z3, len)));


    }
}
