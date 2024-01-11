import Domain.Cinema.Cinema;
import Domain.Movie.Movie;
import Domain.Reservation.Reservation;
import Domain.Seat.Seat;
import Repository.RepoCinema;
import Repository.RepoMovie;
import Repository.RepoReservations;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;


public class Main {

    public static void main(String args[]) {
        RepoCinema cinemaRepo = new RepoCinema("src/main/java/Resources/Cinemas.txt");
        RepoMovie movieRepo = new RepoMovie("src/main/java/Resources/Movies.txt");
        RepoReservations reservationRepo = new RepoReservations("src/main/java/Resources/Reservations.txt");

//
//        for( int i = 0 ; i<= 100 ; i++)
//        {
//            String cinemaName = "cinema" + Integer.toString(i);
//            Cinema cinema = new Cinema(i ,cinemaName);
//            cinemaRepo.addCinema(cinema);
//        }
//
//        Random r = new Random();
//        for( int i = 0 ; i<= 50 ; i++)
//        {
//            String movieName = "movie"+ Integer.toString(i);
//            int cinemaId = i % 5;
//            String date = "05-22-2021";
//            String time = Integer.toString(r.nextInt(12)) + ":" + Integer.toString(r.nextInt(59)+1) ;
//            Movie m = new Movie(cinemaId,movieName,date,time,time);
//            movieRepo.addMovie(m);
//        }



        printMainMenu();
        while(true) {
            boolean validChoice = false;
            int choice;
            Scanner in = new Scanner(System.in);
            try{
            choice = parseInt(in.nextLine());
                switch (choice){
                    case 0:{
                        System.exit(0);
                    }
                    case 1: {
                        validChoice = true;
                        showCinemaList(cinemaRepo);
                        break;
                    }
                    case 2:{
                        validChoice = true;
                        showMovies(movieRepo,cinemaRepo);
                        break;
                    }
                    case 3:
                    {
                        validChoice = true;
                        makeReservation(movieRepo, cinemaRepo,reservationRepo);
                        break;
                    }
                    case 4:
                    {
                        validChoice = true;
                        List<Reservation> reservations = reservationRepo.getAllReservations();
                        for(Reservation reservation:reservations )
                        {
                            System.out.println(reservation);
                        }
                        break;
                    }
                    default:
                    {System.out.println("Please enter a valid choice!");
                        printMainMenu();}
                }

            }
            catch (Exception e)
            {
                System.out.println("Choice must be an integer number (0-3)!");
            }
            

        }
    }

    private static void makeReservation(RepoMovie movieRepo, RepoCinema cinemaRepo, RepoReservations reservationsRepo) {
        System.out.println("Give cinema name: ");
        Scanner in = new Scanner(System.in);
        String cinemaName = in.nextLine();
        System.out.println("These are all the movies running at cinema: " + cinemaName);
        List<Movie> movies = movieRepo.getAllMovies();
        for(Movie movie: movies)
        {
            String movieCinemaName = cinemaRepo.searchById(movie.getCinemaId()).getCinemaName();
            if(movieCinemaName.equals(cinemaName))
            {
                System.out.println(movie.getName() + " runs on the following date " + movie.getDate() + " from " + movie.getStartHour()
                        + " to " + movie.getEndHour());
            }
        }
        System.out.println("Select one of the above movies");
        System.out.println("Movie Name: ");
        String movieName = in.nextLine();
        System.out.println("Date: ");
        String date = in.nextLine();
        System.out.println("Start time: ");
        String startTime =in.nextLine();

        Movie movie = movieRepo.searchMovieByNameDateAndStartTime(movieName,date,startTime);

        List<Seat> seats = cinemaRepo.searchByName(cinemaName).getSeats();
        List<Reservation> reservations = reservationsRepo.getAllReservations();
        ArrayList<Seat> freeSeats = new ArrayList<>();

        for(Seat seat:seats)
        {
            {
                boolean occupiedSeat = false;
                for(Reservation reservation:reservations)
                if(reservation.getSeatID() == seat.getSeatId() && reservation.getMovieName().equals(movieName)
                 &&reservation.getDate().equals(date) && reservation.getStartTime().equals(startTime))
                {
                 occupiedSeat = true;
                }
                if (occupiedSeat == false)
                    freeSeats.add(seat);
            }
        }

        System.out.println("Free seats:");
        for(Seat seat: freeSeats)
        {
            System.out.println(seat);
        }

        System.out.println("Seat ID: ");
        int seatId = parseInt(in.nextLine());
        System.out.println("Your Name: ");
        String customerName = in.nextLine();

        reservations.add(new Reservation(cinemaRepo.searchByName(cinemaName).getCinemaId(), movieName, date, startTime, customerName,seatId));
        System.out.println("Reservation made!");
    }



    private static void showCinemaList(RepoCinema cinemaRepo) {
        List<Cinema> cinemas = cinemaRepo.getAllCinemas();
        for(Cinema cinema:cinemas)
        {
            System.out.println("ID: " + cinema.getCinemaId() +"\nCinemaName: "+ cinema.getCinemaName() + "\n\n" );


        }
    }

    private static void showMovies(RepoMovie movieRepo, RepoCinema cinemaRepo) {
        List<Movie> movies = movieRepo.getAllMovies();
        System.out.println("Give cinema name: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if(input.equals(""))
        {
            for(Movie movie: movies)
                {
                String cinemaName = cinemaRepo.searchById(movie.getCinemaId()).getCinemaName();
                System.out.println("Movie " + movie.getName() + " runs at cinema " + cinemaName
                                    + " on the following date " + movie.getDate() + " from " + movie.getStartHour()
                                    + " to " + movie.getEndHour());
                }
        }
        else
            {
                boolean okPrint = false;
            for(Movie movie: movies)
            {
                String cinemaName = cinemaRepo.searchById(movie.getCinemaId()).getCinemaName();
                if(cinemaName.equals(input))
                {
                    okPrint = true;
                System.out.println("Movie " + movie.getName() + " runs at cinema " + cinemaName
                        + " on the following date " + movie.getDate() + " from " + movie.getStartHour()
                        + " to " + movie.getEndHour());
                }
            }
            if(okPrint == false)
            {
                System.out.println("No movies at this cinema or invalid cinema name!");
            }
            }


    }

    private static void printMainMenu() {
        System.out.println("The available choices are: \n0.Exit\n1.Show cinemas list\n2.Show movies\n3.Make reservation");
    }
}
