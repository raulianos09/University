package ClassicMultiplication;


import Polynomial.Polynomial;

public class ParMultiplier implements Runnable {

    private Polynomial p1;
    private Polynomial p2;
    private Polynomial r;
    private int numberOfThreads;
    private int startingElement;

    public ParMultiplier(Polynomial p1, Polynomial p2, Polynomial r, int numberOfThreads, int startingElement) {
        this.p1 = p1;
        this.p2 = p2;
        this.r = r;
        this.numberOfThreads = numberOfThreads;
        this.startingElement = startingElement;
    }


    @Override
    public void run() {
        int i = this.startingElement;
        while (i < r.getDegree()) {
            for (int p1Coefficient = 0; p1Coefficient < p1.getDegree(); p1Coefficient++)
                for (int p2Coefficient = 0; p2Coefficient < p2.getDegree(); p2Coefficient++)
                    if (p1Coefficient + p2Coefficient == i) {
                        r.setCoefficient(i, r.getCoefficient(i) + p1.getCoefficient(p1Coefficient) * p2.getCoefficient(p2Coefficient));
                    }
            i += this.numberOfThreads;
        }
    }

}
