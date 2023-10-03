package spring.spring_prac1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_prac1.discount.DiscountPolicy;
import spring.spring_prac1.discount.FixDiscountPolicy;
import spring.spring_prac1.discount.RateDiscountPolicy;
import spring.spring_prac1.member.MemberRepository;
import spring.spring_prac1.member.MemberService;
import spring.spring_prac1.member.MemberServiceImpl;
import spring.spring_prac1.member.MemoryMemberRepository;
import spring.spring_prac1.order.OrderService;
import spring.spring_prac1.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
}
