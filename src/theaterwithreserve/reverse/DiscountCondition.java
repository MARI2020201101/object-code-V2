package theaterwithreserve.reverse;

interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening, int audienceCount);
    Money calculateFee(Money fee);
}

abstract class AmountDiscount implements DiscountPolicy.AMOUNT, DiscountCondition{
    private final Money amount;
    public AmountDiscount(Money amount) {
        this.amount = amount;
    }
    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}

abstract class PercentDiscount implements DiscountPolicy.PERCENT, DiscountCondition{
    private final double percent;
    public PercentDiscount(double percent) {
        this.percent = percent;
    }
    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(fee.times(percent));
    }
}

class SequenceAmountDiscount extends AmountDiscount{
    private final int sequence;
    public SequenceAmountDiscount(Money amount, int sequence) {
        super(amount);
        this.sequence = sequence;
    }
    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == sequence;
    }
}
class SequencePercentDiscount extends PercentDiscount{
    private final int sequence;
    public SequencePercentDiscount(double percent, int sequence) {
        super(percent);
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == sequence;
    }
}

