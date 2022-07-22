package theater;

import java.util.ArrayList;
import java.util.List;

class TicketOffice {
    private Long amount; //티켓 오피스의 수익금
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount) {
        this.amount = amount;
    }
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
    public Ticket getTicketWithFee(){
        if(tickets.size() == 0) return Ticket.EMPTY;
        else{
            Ticket ticket = tickets.remove(0);
            amount += ticket.getFee();
            return ticket;
        }
    }
    public Ticket getTicketWithNoFee(){
        if(tickets.size() == 0) return Ticket.EMPTY;
        else return tickets.remove(0);
    }
    public Long getTicketPrice(){
        if(tickets.size()==0) return 0L;
        else return tickets.get(0).getFee();//단방향 의존성
    }
}
