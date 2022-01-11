import mpi.MPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String APPROACH = "Naive1";

    public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int numberOfProcesses = MPI.COMM_WORLD.Size();

        if (rank == 0) {
            Polynomial a = new Polynomial(10);
            Polynomial b = new Polynomial(10);

            a.generateRandom();
            b.generateRandom();

            a.setAllToOne();
            b.setAllToOne();

            System.out.println("First polynomial: " + a);
            System.out.println("Second polynomial: " + b);

            master(a, b, numberOfProcesses);
        } else {
            if (APPROACH.equals("Naive")) {
                simpleWorker(rank);
            } else {
                karatsubaWorker(rank);
            }
        }

        MPI.Finalize();
    }


    private static void master(Polynomial a, Polynomial b, int numberOfProcesses) {
        int start = 0, finish = 0;
        int len = a.getDegree() / (numberOfProcesses - 1);

        for (int i = 1; i < numberOfProcesses; i++) {
            //splitting the polynomial
            start = finish;
            finish += len;

            if (i == numberOfProcesses - 1) {
                finish = a.getDegree();
            }

            MPI.COMM_WORLD.Send(new Object[]{a.getCoefficients().toString().substring(1, a.getCoefficients().toString().length() - 1)}, 0, 1, MPI.OBJECT, i, 0);
            MPI.COMM_WORLD.Send(new Object[]{b.getCoefficients().toString().substring(1, b.getCoefficients().toString().length() - 1)}, 0, 1, MPI.OBJECT, i, 0);

            MPI.COMM_WORLD.Send(new int[]{start}, 0, 1, MPI.INT, i, 0);
            MPI.COMM_WORLD.Send(new int[]{finish}, 0, 1, MPI.INT, i, 0);
        }

        Object[] objResults = new Object[numberOfProcesses - 1];
        for (int i = 1; i < numberOfProcesses; i++) {
            MPI.COMM_WORLD.Recv(objResults, i - 1, 1, MPI.OBJECT, i, 0);
        }

        ArrayList<Polynomial> results = new ArrayList<>();

        for (int i = 0; i < numberOfProcesses - 1; ++i) {
            results.add(new Polynomial(createCoefficientList(objResults, i)));
        }

        Polynomial result = new Polynomial(0);
        for (Polynomial p : results)
            result = Operations.addPolynomials(result, p);
        System.out.println(result);
    }

    private static List<Integer> createCoefficientList(Object[] objCoefficients, int offset) {
        String stringCoefficients = (String) objCoefficients[offset];
        List<String> stringsListCoefficients = Arrays.asList(stringCoefficients.split(","));
        List<Integer> coefficients = new ArrayList<Integer>();
        for (String fav : stringsListCoefficients) {
            coefficients.add(Integer.parseInt(fav.trim()));
        }
        return coefficients;
    }

    private static void karatsubaWorker(int rank) {
        System.out.println("Worker " + rank + " started");

        Object[] objCoefficientsA = new Object[2];
        Object[] objCoefficientsB = new Object[2];

        int[] begin = new int[1];
        int[] end = new int[1];


        MPI.COMM_WORLD.Recv(objCoefficientsA, 0, 1, MPI.OBJECT, 0, 0);
        MPI.COMM_WORLD.Recv(objCoefficientsB, 0, 1, MPI.OBJECT, 0, 0);

        MPI.COMM_WORLD.Recv(begin, 0, 1, MPI.INT, 0, 0);
        MPI.COMM_WORLD.Recv(end, 0, 1, MPI.INT, 0, 0);


        Polynomial a = new Polynomial(createCoefficientList(objCoefficientsA, 0));
        for (int i = 0; i < begin[0]; i++)
            a.setCoefficient(i, 0);
        for (int i = end[0]; i < a.getDegree(); i++)
            a.setCoefficient(i, 0);
        Polynomial b = new Polynomial(createCoefficientList(objCoefficientsB, 0));

        Polynomial result = karatsubaSequential(a, b);

        MPI.COMM_WORLD.Send(new Object[]{result.getCoefficients().toString().substring(1, result.getCoefficients().toString().length() - 1)}, 0, 1, MPI.OBJECT, 0, 0);

    }

    public static Polynomial karatsubaSequential(Polynomial p1, Polynomial p2) {
        if (p1.getDegree() < 2 || p2.getDegree() < 2) {
            return simpleSequential(p1, p2, 0, p1.getDegree());
        }

        int len = Math.max(p1.getDegree(), p2.getDegree()) / 2;
        Polynomial lowFirst = new Polynomial(p1.getCoefficients().subList(0, len));
        Polynomial highFirst = new Polynomial(p1.getCoefficients().subList(len, p1.getDegree()));

        Polynomial lowSecond = new Polynomial(p2.getCoefficients().subList(0, len));
        Polynomial highSecond = new Polynomial(p2.getCoefficients().subList(len, p2.getDegree()));

        Polynomial z1 = karatsubaSequential(highFirst, highSecond);
        Polynomial z2 = karatsubaSequential(lowFirst, lowSecond);
        Polynomial z3 = Operations.subtractPolynomial(Operations.subtractPolynomial
                (karatsubaSequential(Operations.addPolynomials(lowFirst, highFirst), Operations.addPolynomials(lowSecond, highSecond)), z1), z2);

        return Operations.addPolynomials(z2, Operations.addPolynomials(Operations.shiftPolynomial(z1, len * 2), Operations.shiftPolynomial(z3, len)));
    }

    private static void simpleWorker(int rank) {
        System.out.println("Worker " + rank + " started");

        Object[] objCoefficientsA = new Object[2];
        Object[] objCoefficientsB = new Object[2];

        int[] begin = new int[1];
        int[] end = new int[1];


        MPI.COMM_WORLD.Recv(objCoefficientsA, 0, 1, MPI.OBJECT, 0, 0);
        MPI.COMM_WORLD.Recv(objCoefficientsB, 0, 1, MPI.OBJECT, 0, 0);

        MPI.COMM_WORLD.Recv(begin, 0, 1, MPI.INT, 0, 0);
        MPI.COMM_WORLD.Recv(end, 0, 1, MPI.INT, 0, 0);

        Polynomial a = new Polynomial(createCoefficientList(objCoefficientsA, 0));
        Polynomial b = new Polynomial(createCoefficientList(objCoefficientsB, 0));

        Polynomial result = simpleSequential(a, b, begin[0], end[0]);

        MPI.COMM_WORLD.Send(new Object[]{result.getCoefficients().toString().substring(1, result.getCoefficients().toString().length() - 1)}, 0, 1, MPI.OBJECT, 0, 0);
    }

    public static Polynomial simpleSequential(Polynomial a, Polynomial b, int begin, int end) {
        Polynomial result = new Polynomial(a.getDegree() + b.getDegree() - 1);
        for (int i = begin; i < end; i++) {
            for (int j = 0; j < b.getDegree(); j++) {
                result.getCoefficients().set(i + j, result.getCoefficients().get(i + j) + a.getCoefficients().get(i) * b.getCoefficients().get(j));
            }
        }
        return result;
    }

}

