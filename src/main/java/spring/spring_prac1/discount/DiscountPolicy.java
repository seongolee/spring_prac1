package spring.spring_prac1.discount;

import spring.spring_prac1.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}

