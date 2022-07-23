package theaterfactory;


import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening, int audienceCount);
}


class SequenceDiscountCondition implements DiscountCondition{
    private int sequence;

    public SequenceDiscountCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == this.sequence;
    }
}

class DayOfWeekDiscountCondition implements DiscountCondition{
    private Set<DayOfWeek> dayOfWeeks = new HashSet<>();

    public DayOfWeekDiscountCondition(DayOfWeek... dayOfWeek) {
        this.dayOfWeeks.addAll(Arrays.asList(dayOfWeek));
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        for(DayOfWeek dayOfWeek : dayOfWeeks){
            if(screening.whenScreened.getDayOfWeek() ==  dayOfWeek) return true;
        }
        return false;
    }
}