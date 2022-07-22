package theaterstrategy;

import java.util.HashSet;
import java.util.Set;

abstract class DiscountPolicy {
    private Set<DiscountCondition> conditions = new HashSet<>();
    public void addCondition(DiscountCondition condition){
        this.conditions.add(condition);
    }
    public Money calculateFee(Screening screening, int count, Money fee){
        for(DiscountCondition condition: conditions){
            if(condition.isSatisfiedBy(screening, count))
                return calculateFee(fee);
        }
        return fee;
    }

    abstract protected Money calculateFee(Money fee);
}

class AmountDiscountPolicy extends DiscountPolicy{
    private Money amount;
    public AmountDiscountPolicy(Money amount) {
        this.amount = amount;
    }
    @Override
    protected Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}

class PercentDiscountPolicy extends DiscountPolicy{
    private double percent;
    public PercentDiscountPolicy(double percent) {
        this.percent = percent;
    }
    @Override
    protected Money calculateFee(Money fee) {
        return fee.minus(fee.times(percent));
    }
}

class NoSalePolicy extends DiscountPolicy{
    @Override
    protected Money calculateFee(Money fee) {
        return fee;
    }
}


