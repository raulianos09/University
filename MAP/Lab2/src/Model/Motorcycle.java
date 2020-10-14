package Model;

public class Motorcycle implements IVehicle{

    int id;
    String color;

    public Motorcycle(int id, String color){
        this.id = id;
        this.color = color;
    }

    public int getId()
    {
        return id;
    }

    public String getColor()
    {
        return color;
    }

    public String toString()
    {
       return ("Motorcycle with ID: " + id + " is " + color.toLowerCase()+ "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Motorcycle))
            return false;

        Motorcycle motorcycle = (Motorcycle) obj;
        return (motorcycle.getId() == this.getId());
    }
}

