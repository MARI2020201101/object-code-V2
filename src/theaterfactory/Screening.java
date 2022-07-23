package theaterfactory;

import java.time.LocalDateTime;

class Screening {
    final int sequence;
    final LocalDateTime whenScreened;
    private int seat;

    public Screening(int sequence, LocalDateTime whenScreened, int seat) {
        this.sequence = sequence;
        this.whenScreened = whenScreened;
        this.seat = seat;
    }
    boolean hasSeat(int count){
        return seat >= count;
    }
    void reserveSeat(int count){
        if(hasSeat(count)) seat-=count;
        else throw new RuntimeException("no seat");
    }

    @Override
    public String toString() {
        return "Screening{" +
                "sequence=" + sequence +
                ", whenScreened=" + whenScreened +
                ", seat=" + seat +
                '}';
    }
}
