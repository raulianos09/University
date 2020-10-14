package SplProblem;

public class Dog {

    String name = "";
    int age = 0;
    double weight = 0;

    public Dog() {
    }

    public Dog(String _name, String _age, String _weight)
    {
        this.name = _name;
        try
        {
            this.age = Integer.parseInt(_age);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Age for dogs should be numeric type.");
        }

        try
        {
            this.weight = Double.parseDouble(_weight);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Weight for dogs should be numeric type.");
        }
    }

    public String toString()
    {
        if ( !name.equals("") && age!= 0 && weight !=0)
           // System.out.println(this.name + " is a " + this.age + " years old dog and weights " + this.weight + " KG.");
            return (this.name + " is a " + this.age + " years old dog and weights " + this.weight + " KG.");
        return "Invalid data";
    }

}
