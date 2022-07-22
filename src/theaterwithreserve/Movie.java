package theaterwithreserve;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Movie<T extends DiscountPolicy & DiscountCondition> {
    private String title;
    private Duration runningTime; //영화상영시간
    private Money fee;
    private Set<T> discountConditions = new HashSet<>();

    public Movie(String title, Duration runningTime, Money fee, T ...conditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions.addAll(Arrays.asList(conditions));
    }
    Money calculateFee(Screening screening, int audienceCount){
       return Money.ZERO;
    }
}
