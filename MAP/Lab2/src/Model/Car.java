package Model;

public class Car implements IVehicle{

    int id;
    String color;

    public Car(int id, String color){
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
        return ("Car with ID: " + id + " is " + color.toLowerCase() + "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Car))
            return false;

        Car otherCar = (Car) obj;
        return (otherCar.getId() == this.getId());
    }
}
