package spring.spring_prac1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_prac1.member.MemberService;

import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {
    @Test
    void basicScan() {
        // getBean을 사용하려면 AnnotationConfigAPplicationContext 인터페이스를 사용해야 한다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}