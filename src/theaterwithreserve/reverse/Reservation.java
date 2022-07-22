package theaterwithreserve.reverse;

class Reservation {
    static final Reservation NONE = new Reservation(null,null,null,0);
    final Theater theater;
    final Movie movie;
    final Screening screening;
    final int count;

    Reservation(Theater theater, Movie movie, Screening screening, int count) {
        this.theater = theater;
        this.movie = movie;
        this.screening = screening;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "theater=" + theater +
                ", movie=" + movie +
                ", screening=" + screening +
                ", count=" + count +
                '}';
    }
}
