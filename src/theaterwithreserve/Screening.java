package theaterwithreserve;

import java.time.LocalDateTime;

class Screening {
    final int sequence;
    private final LocalDateTime screenTime;
    private final int seatCount;

    public Screening(int sequence, LocalDateTime screenTime, int seatCount) {
        this.sequence = sequence;
        this.screenTime = screenTime;
        this.seatCount = seatCount;
    }
}
