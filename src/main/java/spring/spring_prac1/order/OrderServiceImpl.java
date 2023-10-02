package spring.spring_prac1.order;

import spring.spring_prac1.discount.DiscountPolicy;
import spring.spring_prac1.discount.FixDiscountPolicy;
import spring.spring_prac1.member.Member;
import spring.spring_prac1.member.MemberRepository;
import spring.spring_prac1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
