package Repository;

import Model.*;
import java.lang.Exception;

public interface IRepository {
    void add(IVehicle vehicle) throws Exception;
    void remove(IVehicle vehicle) throws Exception;
    IVehicle[] getAll();
}
