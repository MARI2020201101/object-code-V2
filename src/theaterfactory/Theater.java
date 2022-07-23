package theaterfactory;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Theater {
    public static final Set<Screening> EMPTY = new HashSet<>();
    private final Money amount;
    private Set<TicketOffice> ticketOffices = new HashSet<>();
    private final Map<Movie, Set<Screening>> movies = new HashMap<>();


    public Theater(Money amount) {
        this.amount = amount;
    }

    public boolean addMovie(Movie movie) {
        if(movies.containsKey(movie)) return true;
        this.movies.put(movie, new HashSet<>());
        return true;
    }
    public boolean addScreening(Movie movie, Screening screening){
        if(! movies.containsKey(movie)) return false;
        this.movies.get(movie).add(screening); return true;
    }
    public boolean contractTicketOffice(TicketOffice ticketOffice, double rate){
        if(! ticketOffice.contract(this, rate)) return false;
        return ticketOffices.add(ticketOffice);
    }
    public boolean cancelTicketOffice(TicketOffice ticketOffice, double rate){
        if(! ticketOffices.contains(ticketOffice) || ticketOffice.cancel(this)) return false;
        return ticketOffices.remove(ticketOffice);
    }

    void plusAmount(Money amount){
        this.amount.plus(amount);
    }
    public Set<Screening> getScreening(Movie movie) {
        if(! movies.containsKey(movie) || movies.get(movie).size() == 0) return EMPTY;
        return movies.get(movie);
    }
    boolean isValidScreening(Movie movie, Screening screening){
        return movies.containsKey(movie) && movies.get(movie).contains(screening);
    }
    public boolean enter(Customer customer, int count){
        Reservation reservation = customer.reservation;

        return reservation != Reservation.NONE &&
                reservation.theater == this &&
                isValidScreening(reservation.movie, reservation.screening) &&
                reservation.count == count;
    }
    Reservation reserve(Movie movie, Screening screening, int count){
        if(!isValidScreening(movie,screening) || ! screening.hasSeat(count)) return Reservation.NONE;
        screening.reserveSeat(count);
        return new Reservation(this, movie, screening, count);
    }


}
