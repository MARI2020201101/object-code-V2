package theaterwithreserve;

import java.util.ArrayList;
import java.util.List;

class Theater {
    private final Money fee;
    private List<Movie> movies = new ArrayList<>();
    private List<Screening> screenings = new ArrayList<>();
    public Theater(Money fee) {
        this.fee = fee;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }
    public void addScreening(Movie movie, Screening screening){
        this.screenings.add(screening);
    }
    public void contractTicketOffice(TicketOffice ticketOffice, double contractFee){

    }

    public List<Screening> getScreening() {
        return screenings;
    }
    public boolean enter(Customer customer, int count){
        return false;
    }
}
