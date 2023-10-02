package spring.spring_prac1.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.spring_prac1.member.Grade;
import spring.spring_prac1.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discountPrice = discountPolicy.discount(member, 10000);
        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discountPrice = discountPolicy.discount(member, 10000);
        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}