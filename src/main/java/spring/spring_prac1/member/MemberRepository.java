package spring.spring_prac1.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
