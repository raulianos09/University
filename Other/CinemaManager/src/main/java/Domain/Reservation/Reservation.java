package Domain.Reservation;

import java.io.Serializable;

public class Reservation implements Serializable {
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public Reservation(int cinemaId, String movieName, String date, String startTime, String customerName, int seatID) {
        this.cinemaId = cinemaId;
        this.movieName = movieName;
        this.date = date;
        this.startTime = startTime;
        this.customerName = customerName;
        this.seatID = seatID;
    }

    private int cinemaId;
    private String movieName;
    private String date;
    private String startTime;
    private String customerName;
    private int seatID;

    @Override
    public String toString() {
        return "Reservation{" +
                "cinemaId=" + cinemaId +
                ", movieName='" + movieName + '\'' +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", customerName='" + customerName + '\'' +
                ", seatID=" + seatID +
                '}';
    }
}
