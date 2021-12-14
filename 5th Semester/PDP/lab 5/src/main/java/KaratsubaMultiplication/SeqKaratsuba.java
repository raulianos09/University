package KaratsubaMultiplication;

import ClassicMultiplication.SeqMultiplier;
import Polynomial.Polynomial;

import static Polynomial.Operations.*;

public class SeqKaratsuba {
    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        if (p1.getDegree() < 2 || p2.getDegree() < 2) {
            return SeqMultiplier.multiply(p1, p2);
        }
        int len = Math.max(p1.getDegree(), p2.getDegree()) / 2;
        Polynomial lowFirst = new Polynomial(p1.getCoefficients().subList(0, len));
        Polynomial highFirst = new Polynomial(p1.getCoefficients().subList(len, p1.getDegree()));

        Polynomial lowSecond = new Polynomial(p2.getCoefficients().subList(0, len));
        Polynomial highSecond = new Polynomial(p2.getCoefficients().subList(len, p2.getDegree()));

        Polynomial z1 = SeqKaratsuba.multiply(highFirst, highSecond);
        Polynomial z2 = SeqKaratsuba.multiply(lowFirst, lowSecond);
        Polynomial z3 = subtractPolynomial(subtractPolynomial(SeqKaratsuba.multiply(addPolynomials(lowFirst, highFirst), addPolynomials(lowSecond, highSecond)) , z1),z2);

        return addPolynomials(z2 , addPolynomials(shiftPolynomial(z1,len * 2),shiftPolynomial(z3,len)));
    }


}
