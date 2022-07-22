package theater;

class Audience {
    private Invitation invitation = Invitation.EMPTY;
    private Ticket ticket = Ticket.EMPTY;
    private Long amount;

    public Audience(Long amount) {
        this.amount = amount;
    }
    public void buyTicket(TicketSeller seller){
        this.ticket = seller.getTicket(this);
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }
    public Ticket getTicket() {
        return ticket;
    }

    public Invitation getInvitaion() {
        return invitation;
    }
    public void removeInvitation() {
        this.invitation=Invitation.EMPTY;
    }
    public boolean hasAmount(Long ticketPrice) {
        return amount >= ticketPrice ;
    }
    public boolean minusAmount(Long amount) {
        if(amount > this.amount ) return false;
        this.amount -= amount;
        return true;
    }
}
