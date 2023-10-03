package spring.spring_prac1;

import spring.spring_prac1.discount.DiscountPolicy;
import spring.spring_prac1.discount.FixDiscountPolicy;
import spring.spring_prac1.member.MemberRepository;
import spring.spring_prac1.member.MemberService;
import spring.spring_prac1.member.MemberServiceImpl;
import spring.spring_prac1.member.MemoryMemberRepository;
import spring.spring_prac1.order.OrderService;
import spring.spring_prac1.order.OrderServiceImpl;

public class AppConfig {

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
}
