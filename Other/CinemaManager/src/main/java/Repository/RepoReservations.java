package Repository;

import Domain.Reservation.Reservation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepoReservations {

    private String filePath = "";
    private ArrayList<Reservation> reservations;

    public RepoReservations(String filePath) {
        this.filePath = filePath;
        this.reservations = new ArrayList<>();
        this.readFromFile();
    }

    private void readFromFile() {
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(file);
            this.reservations.clear();
            this.reservations = (ArrayList<Reservation>)ois.readObject();

        }
        catch (IOException | ClassNotFoundException e)
        {

        }
    }

    private void writeToFile()
    {
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(this.reservations);
        }
        catch (IOException e)
        {

        }
    }

    public void addReservation(Reservation reservation)
    {
        this.reservations.add(reservation);
        this.writeToFile();
    }


    public void deleteReservation(Reservation reservation)
    {
        this.reservations.remove(reservation);
        writeToFile();
    }


    public List<Reservation> getAllReservations()
    {
        return this.reservations;
    }


}
