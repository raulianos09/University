package Domain.Movie;

import java.io.Serializable;

import java.util.Objects;

public class Movie implements Serializable {
    private int cinemaId;
    private String name;
    private String date;
    private String startHour;
    private String endHour;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getCinemaId() == movie.getCinemaId() &&
                Objects.equals(getName(), movie.getName()) &&
                Objects.equals(getDate(), movie.getDate()) &&
                Objects.equals(getStartHour(), movie.getStartHour()) &&
                Objects.equals(getEndHour(), movie.getEndHour());
    }

    public Movie(int cinemaId, String name, String date, String startHour, String endHour) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}
