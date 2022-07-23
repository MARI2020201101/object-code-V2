package theaterfactory;

import java.util.HashSet;
import java.util.Set;

class DiscountPolicy {
    private PolicyFactory factory;
    public DiscountPolicy(PolicyFactory factory){
        this.factory = factory;
    }
    public Money calculateFee(Screening screening, int count, Money fee){
        return factory.calculateFee(screening,count,fee);
    }
}

