package Model;

public interface IVehicle {
        String getColor();
        int getId();
        String toString();
        @Override
        boolean equals(Object other);
}