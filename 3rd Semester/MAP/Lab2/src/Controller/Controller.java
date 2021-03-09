package Controller;

import Model.*;
import Repository.*;

public class Controller {
    IRepository repo;

    public Controller(IRepository repo)
    {
        this.repo = repo;
    }

    public void add(IVehicle v) throws Exception
    {
        repo.add(v);
    }

    public void remove(IVehicle v) throws Exception
    {
        repo.remove(v);
    }

    public  IVehicle[] solve()
    {
        IVehicle[] allVehicles = repo.getAll();
        IVehicle[] redVehicles = null;
        int count = 0;
        int current = 0;

        for (IVehicle vehicle : allVehicles) {

            if (vehicle.getColor().toLowerCase().equals("red"))
                count++;
        }

        if(count > 0)
        {
            redVehicles = new IVehicle[count];
            for (IVehicle vehicle : allVehicles)
                if (vehicle.getColor().toLowerCase().equals("red")) {
                    redVehicles[current] = vehicle;
                    current++;
                }
        }
        return redVehicles;

    }
}
