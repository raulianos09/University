package Model;

public class Bicycle implements IVehicle{

    int id;
    String color;

    public Bicycle(int id, String color){
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
        return ("Bicycle with ID: " + id + " is " + color.toLowerCase() + "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Bicycle))
            return false;

        Bicycle otherBicycle = (Bicycle) obj;
        return (otherBicycle.getId() == this.getId());
    }
}