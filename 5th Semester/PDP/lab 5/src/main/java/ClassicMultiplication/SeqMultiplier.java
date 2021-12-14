package ClassicMultiplication;


import Polynomial.Polynomial;

public class SeqMultiplier {
    public static Polynomial multiply(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial(p1.getDegree() + p2.getDegree() -  1);
        for (int i = 0 ; i < p1.getDegree(); i++)
            for(int j = 0 ; j < p2.getDegree() ; j++)
            {
                result.setCoefficient(i+j, result.getCoefficient(i+j) + p1.getCoefficient(i) * p2.getCoefficient(j));
            }
        return result;
    }
}
