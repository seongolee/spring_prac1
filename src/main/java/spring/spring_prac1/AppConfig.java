package spring.spring_prac1;

import spring.spring_prac1.discount.FixDiscountPolicy;
import spring.spring_prac1.member.MemberService;
import spring.spring_prac1.member.MemberServiceImpl;
import spring.spring_prac1.member.MemoryMemberRepository;
import spring.spring_prac1.order.OrderService;
import spring.spring_prac1.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy()
        );
    }
}
