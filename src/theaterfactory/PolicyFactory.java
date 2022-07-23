package theaterfactory;

import java.util.HashSet;
import java.util.Set;

interface PolicyFactory extends Calculator{
    default Money calculateFee(Screening screening, int count, Money fee){
        for(DiscountCondition condition :getConditions()){
            if(condition.isSatisfiedBy(screening,count)) return calculateFee(fee);
        }
        return fee;
    };
    Set<DiscountCondition> getConditions();
}
class AmountPolicyFactory implements PolicyFactory{
    private Money amount;
    private AmountCalculator cache;
    private Set<DiscountCondition> conditions = new HashSet<>();

    public AmountPolicyFactory(Money amount) {
        this.amount = amount;
    }

    synchronized private Calculator getCalculator(){
        if(cache == null) cache = new AmountCalculator(amount);
        return cache;
    }
    public void addCondition(DiscountCondition condition){
        this.conditions.add(condition);
    }

    @Override
    public Set<DiscountCondition> getConditions() {
        return conditions;
    }

    @Override
    public Money calculateFee(Money fee) {
        return cache.calculateFee(fee);
    }
}
class PercentPolicyFactory implements PolicyFactory{
    private double percent;
    private Set<DiscountCondition> conditions = new HashSet<>();
    private PercentCalculator cache;
    public PercentPolicyFactory(double percent) {
        this.percent = percent;
    }
    synchronized private Calculator getCalculator(){
        if(cache == null) cache = new PercentCalculator(percent);
        return cache;
    }
    public void addCondition(DiscountCondition condition){
        this.conditions.add(condition);
    }

    @Override
    public Set<DiscountCondition> getConditions() {
        return conditions;
    }
    @Override
    public Money calculateFee(Money fee) {
        return cache.calculateFee(fee);
    }
}