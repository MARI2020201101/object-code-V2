package theaterwithreserve.reverse;

// enum 대신 마커 인터페이스를 활용하여 if 문을 줄일수있다!!
interface DiscountPolicy {
    interface AMOUNT extends DiscountPolicy{
    }
    interface PERCENT extends DiscountPolicy{
    }
    interface COUNT extends DiscountPolicy{
    }
    interface NONE extends DiscountPolicy{
    }
}


