package theaterfactory;


import java.time.Duration;

class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }
    Money calculateFee(Screening screening, int audienceCount){
        return discountPolicy.calculateFee(screening, audienceCount, fee);
    }
}
