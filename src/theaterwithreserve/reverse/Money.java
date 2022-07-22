package theaterwithreserve.reverse;

import java.math.BigDecimal;

class Money {
    // 값객체는 모든 필드가 final 이어야 한다. 동시성문제에서 자유롭다. 늘 new 를 리턴한다.
    public static final Money ZERO = Money.of(0);
    private final BigDecimal amount;

    public static Money of(double amount){
        return new Money(BigDecimal.valueOf(amount));
    }
    Money(BigDecimal amount) {
        this.amount=amount;
    }
    public Money plus(Money amount){
        return new Money(this.amount.add(amount.amount));
    }
    public Money minus(Money amount){
        return new Money(this.amount.subtract(amount.amount));
    }
    public Money times(double percent){
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }
    public boolean isLessThan(Money other){
        return amount.compareTo(other.amount) < 0;
    }
    public boolean isGreaterThanOrEqual(Money other){
        // 내부를 은닉하고 만든 API 로만 통신 -> 안전!
        return amount.compareTo(other.amount) >= 0;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
