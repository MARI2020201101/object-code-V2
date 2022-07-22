package theaterstrategy;

import java.time.DayOfWeek;
import java.time.Duration;

class Main {
    public static void main(String[] args) {
        DiscountPolicy discountPolicy = new AmountDiscountPolicy(Money.of(1000));
        discountPolicy.addCondition(new SequenceDiscountCondition(2));
        discountPolicy.addCondition(
                new DayOfWeekDiscountCondition(
                        DayOfWeek.MONDAY,DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,DayOfWeek.FRIDAY));
        Movie titanic = new Movie(
                "타이타닉"
                , Duration.ofMinutes(130)
                , Money.of(11000)
                , discountPolicy
        );
    }
}
