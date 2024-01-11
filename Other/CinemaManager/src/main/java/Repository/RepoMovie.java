package Repository;

import Domain.Cinema.Cinema;
import Domain.Movie.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepoMovie {
    private String filePath = "";
    private ArrayList<Movie> movies;

    public RepoMovie(String filePath) {
        this.filePath = filePath;
        this.movies = new ArrayList<>();
        this.readFromFile();
    }

    private void readFromFile() {
        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(file);
            this.movies.clear();
            this.movies = (ArrayList<Movie>)ois.readObject();

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
            oos.writeObject(this.movies);
        }
        catch (IOException e)
        {

        }
    }

    public Movie searchMovieByNameDateAndStartTime(String movieName, String date, String startTime)
    {
        for(Movie movie:this.movies)
        {
            if (movie.getName().equals(movieName) &&
                movie.getDate().equals(date)&&
                movie.getStartHour().equals(startTime))
                return movie;
        }
        return null;
    }

    public void addMovie(Movie movie)
    {
        this.movies.add(movie);
        this.writeToFile();
    }


    public void deleteMovie(Movie movie)
    {
        this.movies.remove(movie);
        writeToFile();
    }


    public List<Movie> getAllMovies()
    {
        return this.movies;
    }
}
