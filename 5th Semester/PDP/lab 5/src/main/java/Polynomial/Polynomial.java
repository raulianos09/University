package Polynomial;

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

    private static String superscript(String str) {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        return str;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = degree; i > 1; i--) {
            str.append(this.coefficients.get(degree - i)).append(" X").append(superscript(Integer.toString(i-1))).append(" + ");
        }
        str.append(this.coefficients.get(degree-1));
        return str.toString();
    }
}
