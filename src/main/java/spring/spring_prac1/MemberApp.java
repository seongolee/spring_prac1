package spring.spring_prac1;

import spring.spring_prac1.member.Grade;
import spring.spring_prac1.member.Member;
import spring.spring_prac1.member.MemberService;
import spring.spring_prac1.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
