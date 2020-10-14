package SplProblem;

import java.awt.font.NumericShaper;

public class Puppy extends Dog{

    public Puppy(){}

    //Please give age in months for puppies
    public Puppy(String _name, String _age, String _weight){
        this.name = _name;
        try
        {
            this.age = Integer.parseInt(_age);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Age for puppies should be numeric type.");
        }

        try
        {
            this.weight = Double.parseDouble(_weight);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Weight for puppies should be numeric type.");
        }

    }

    @Override
    public String toString()
    {
        if ( !name.equals("") && age!= 0 && weight !=0)
            //System.out.println(this.name + " is a " + this.age + " months old puppy and weights " + this.weight + " KG.");
            return (this.name + " is a " + this.age + " months old puppy and weights " + this.weight + " KG.");
        return "Invalid data";
    }

}