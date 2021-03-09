package Repository;

import Model.*;
import java.lang.Exception;

public class InMemoryRepo implements IRepository{
    IVehicle[] elements;
    int capacity;
    int length;

    public InMemoryRepo(int capacity)
    {
        this.elements = new IVehicle[capacity];
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(IVehicle v) throws Exception
    {
    if (this.length == this.capacity)
        throw new Exception("ERROR. Repository is full!!");

        for(int i=0; i<this.length;i++)
         {
          if(this.elements[i].equals(v))
                throw new Exception("ERROR. Vehicle already in list!");
         }
    this.elements[this.length] = v;
    this.length++;

    }

    public void remove(IVehicle v)throws Exception
    {
        boolean vehicleRemoved = false;

        for (int i = 0; i < this.length; i++) {
            if (this.elements[i].equals(v))
            {
                for (int j = i; j < this.length - 1; j++)
                    this.elements[j] = this.elements[j + 1];
                this.length--;
                i--;
                vehicleRemoved = true;
            }
        }
        if (!vehicleRemoved) {
            throw new Exception("ERROR. Vehicle not found!");
        }


    }

    public IVehicle[] getAll()
    {
        IVehicle[] allVehicles = new IVehicle[this.length];
        for (int i = 0 ;i<this.length;i++)
            allVehicles[i] = this.elements[i];
        return allVehicles;

    }

}
