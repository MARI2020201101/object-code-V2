package theater;

class Ticket {
    private final Theater theater;
    private boolean isEntered = false;
    final static public Ticket EMPTY = new Ticket(null);

    public Ticket(Theater theater) {
        this.theater=theater;
    }

    public boolean isValid(Theater theater) {
        if(isEntered || this.theater != theater || this == EMPTY )
            return false;
        else{
            isEntered = true;
            return true;
        }
    }
    public Long getFee(){
        return theater.getFee();//위임
    }
}
