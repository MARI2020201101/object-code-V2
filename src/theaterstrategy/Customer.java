package theaterstrategy;

class Customer {
    private final Money amount;
    public Reservation reservation;

    Customer(Money amount) {
        this.amount = amount;
    }
    public Reservation reserve(TicketSeller seller, Theater theater, Movie movie, Screening screening, int count){
       this.reservation = seller.reserve(this, theater, movie, screening, count);
       return reservation;
    }

    boolean hasAmount(Money price) {
        return amount.isGreaterThanOrEqual(price);
    }

    void minusAmount(Money price) {
        amount.minus(price);
    }

}
