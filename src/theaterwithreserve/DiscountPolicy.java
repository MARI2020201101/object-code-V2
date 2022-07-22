package theaterwithreserve;

interface DiscountPolicy {
    interface AMOUNT extends DiscountPolicy{
//마커 인터페이스. enum 은 클래스타입으로 받을 수 없음
    }
    interface PERCENT extends DiscountPolicy{
    }
    interface COUNT extends DiscountPolicy{
    }
    interface NONE extends DiscountPolicy{
    }
}


