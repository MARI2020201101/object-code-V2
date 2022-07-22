package theaterwithreserve.reverse;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Theater theater = new Theater(Money.of(10000));
        Movie<AmountDiscount> movie = new Movie(
                "탑건"
                , Duration.ofMinutes(120)
                , Money.of(10000)
                , new SequenceAmountDiscount(Money.of(900), 1)
        );
        theater.addMovie(movie);
        for(int i = 0, j = 0; i <10; i+=2, j++){
            Screening screening = new Screening(
                    j
                    , LocalDateTime.of(2022, 7,22, i, 0,0)
                    , 100);
            theater.addScreening(movie, screening);
        }

        TicketOffice ticketOffice = new TicketOffice(Money.of(200));
        ticketOffice.contract(theater, 10.0);

        TicketSeller seller = new TicketSeller();
        seller.setTicketOffice(ticketOffice);

        Customer customer = new Customer(Money.of(30000));
        Set<Screening> screening = theater.getScreening(movie);
        Screening screening1 = screening.stream().findFirst().get();
        Reservation reservation = customer.reserve(seller, theater, movie, screening1, 2);
        boolean isOk = theater.enter(customer, 2);
        System.out.println("reserved info => "+ reservation);
        System.out.println("isOk => " + isOk);
    }
}
