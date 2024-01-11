package Repository;

import Domain.Cinema.Cinema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepoCinema {
    private String filePath = "";
    private ArrayList<Cinema> cinemas;

    public RepoCinema(String filePath) {
        this.filePath = filePath;
        this.cinemas = new ArrayList<>();
        this.readFromFile();
    }

    public Cinema searchByName(String cinemaName)
    {
        for(Cinema cinema:this.cinemas)
        {
            if (cinema.getCinemaName().equals(cinemaName))
                return cinema;
        }
        return null;
    }


    public Cinema searchById(int cinemaId)
    {
        for(Cinema cinema:this.cinemas)
        {
            if (cinema.getCinemaId() == cinemaId)
                return cinema;
        }
        return null;
    }

    private void readFromFile() {
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(file);
            this.cinemas.clear();
            this.cinemas = (ArrayList<Cinema>)ois.readObject();

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
            oos.writeObject(this.cinemas);
        }
        catch (IOException e)
        {

        }
    }

    public void addCinema(Cinema cinema)
    {
        this.cinemas.add(cinema);
        this.writeToFile();
    }


    public void deleteCinema(Cinema cinema)
    {
        this.cinemas.remove(cinema);
        writeToFile();
    }


    public List<Cinema> getAllCinemas()
    {
        return this.cinemas;
    }

}
