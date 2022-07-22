package theaterstrategy;


import java.util.HashMap;
import java.util.Map;

class TicketOffice {
    private Money amount;
    private Map<Theater,Double> commissionRate = new HashMap<>();

    public TicketOffice(Money amount) {
        this.amount = amount;
    }
    public boolean contract(Theater theater, double rate) {
        if(commissionRate.containsKey(theater)) return false;
        commissionRate.put(theater,rate);
        return true;
    }

    public boolean cancel(Theater theater) {
        if(! commissionRate.containsKey(theater)) return false;
        commissionRate.remove(theater);
        return true;
    }

    Reservation reserve(Theater theater, Movie movie, Screening screening, int count){
        if(
                !commissionRate.containsKey(theater) ||
                        ! theater.isValidScreening(movie,screening) ||
                        ! screening.hasSeat(count)
        )return Reservation.NONE;
        Reservation reservation = theater.reserve(movie, screening, count);
        if( reservation != Reservation.NONE){
            Money sales = calculateFee(movie, screening, count);
            Money commission = sales.times(commissionRate.get(theater));
            amount.plus(commission);
            theater.plusAmount(sales.minus(commission));
        }
        return reservation;
    }

    public Money calculateFee(Movie movie, Screening screening, int count) {
        return movie.calculateFee(screening, count).times(count);
    }
}
