package spring.spring_prac1.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.spring_prac1.AppConfig;
import spring.spring_prac1.member.Grade;
import spring.spring_prac1.member.Member;
import spring.spring_prac1.member.MemberService;
import spring.spring_prac1.member.MemberServiceImpl;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
