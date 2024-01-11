package Domain.Cinema;

import Domain.Seat.Seat;

import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable {

    int cinemaId;
    String cinemaName;
    ArrayList<Seat> seats;

    @Override
    public String toString() {
        return "Cinema{" +
                "cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", seats=" + seats +
                '}';
    }

    public Cinema(int cinemaId, String cinemaName) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.seats = new ArrayList<>();

        for(int i = 1; i<=50 ;i++)
        {
            Seat seat = new Seat(i,i/10+1,i%10+1);
            this.seats.add(seat);
        }
    }



    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
