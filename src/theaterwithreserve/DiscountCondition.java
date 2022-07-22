package theaterwithreserve;

interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening, int audienceCount);
    Money calculateFee(Money fee);
}
abstract class SequenceDiscount implements DiscountCondition{
    private final int sequence;

    public SequenceDiscount(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == sequence;
    }
}
class SequenceAmountDiscount extends SequenceDiscount implements DiscountPolicy.AMOUNT{
    private final Money amount;
    SequenceAmountDiscount(int sequence , Money amount) {
        super(sequence);
        this.amount = amount;
    }
    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}


class SequencePercentDiscount extends SequenceDiscount implements DiscountPolicy.PERCENT{
    private final double percent;
    SequencePercentDiscount(int sequence , double percent) {
        super(sequence);
        this.percent = percent;
    }
    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(fee.times(percent));
    }
}