package theaterfactory;

interface Calculator {
    Money calculateFee(Money fee);
}
class AmountCalculator implements Calculator{
    private Money amount;

    public AmountCalculator(Money amount) {
        this.amount = amount;
    }

    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}
class PercentCalculator implements Calculator {
    private double percent;

    public PercentCalculator(double percent) {
        this.percent = percent;
    }

    @Override
    public Money calculateFee(Money fee) {
        return fee.minus(fee.times(percent));
    }
}

