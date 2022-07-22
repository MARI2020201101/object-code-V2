package theaterwithreserve.reverse;

class Customer {
    private final Money amount;
    public Reservation reservation;

    Customer(Money amount) {
        this.amount = amount;
    }
    public Reservation reserve(TicketSeller seller, Theater theater, Movie movie, Screening screening, int count){
       return seller.reserve(this, theater, movie, screening, count);
    }

    boolean hasAmount(Money price) {
        return amount.isGreaterThanOrEqual(price);
    }

    void minusAmount(Money price) {
        amount.minus(price);
    }

}
