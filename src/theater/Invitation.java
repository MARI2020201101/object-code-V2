package theater;

class Invitation {
    private final Theater theater;
    final static public Invitation EMPTY = new Invitation(null);
    public Invitation(Theater theater) {
        this.theater=theater;
    }
}
