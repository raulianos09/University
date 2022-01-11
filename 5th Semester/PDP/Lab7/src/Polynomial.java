import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Polynomial {
    private List<Integer> coefficients;
    private int degree;

    public Polynomial(int degree) {
        this.coefficients = new ArrayList<Integer>();
        this.degree = degree;
        for (int i = 0; i < degree; i++)
            this.coefficients.add(0);
    }

    public Polynomial(List<Integer> coefficients)
    {
        this.coefficients = coefficients;
        this.degree = coefficients.size();
    }

    public int getDegree() {
        return degree;
    }

    public void setCoefficient(int index, int value)
    {
        this.coefficients.set(index, value);
    }

    public int getCoefficient(int index)
    {
        return this.coefficients.get(index);
    }

    public List<Integer> getCoefficients() {
        return coefficients;
    }

    public void generateRandom() {
        Random r = new Random();
        for (int i = degree; i > 0; i--) {
            this.coefficients.set(degree - i, r.nextInt(100));
        }
    }
    public void setAllToOne(){
        for (int i = degree; i > 0; i--) {
            this.coefficients.set(degree - i, 1);
    }}


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = degree; i > 1; i--) {
            str.append(this.coefficients.get(degree - i)).append(" X^").append(i-1).append(" + ");
        }
        str.append(this.coefficients.get(degree-1));
        return str.toString();
    }
}
