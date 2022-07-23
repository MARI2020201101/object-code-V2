package theaterfactory;

interface CalculatorFactory {
//     Calculator getCalculator();
     Money calculateFee(Money amount);

}
class AmountCalculatorFactory implements CalculatorFactory{
//    private AmountCalculator cache;
    private Money fee;

    public AmountCalculatorFactory(Money fee) {
        this.fee = fee;
    }

//    @Override
//    public synchronized Calculator getCalculator() {
//        if(cache == null) cache = new AmountCalculator(fee);
//        return cache;
//    }

    @Override
    public Money calculateFee(Money amount) {
        return amount.minus(amount);
    }
}
class PercentCalculatorFactory implements CalculatorFactory{
//    private PercentCalculator cache;
    private double percent;

    public PercentCalculatorFactory(double percent) {
        this.percent = percent;
    }

//    @Override
//    public Calculator getCalculator() {
//        if(cache == null) cache = new PercentCalculator(percent);
//        return cache;
//    }

    @Override
    public Money calculateFee(Money amount) {
        return amount.minus(amount.times(percent));
    }
}