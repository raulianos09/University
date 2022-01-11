import java.util.ArrayList;
import java.util.List;

public class Operations {

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
                    coefficients.add(p2.getCoefficient(i));
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
