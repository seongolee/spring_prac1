package spring.spring_prac1.beanDefinitionTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_prac1.AppConfig;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName +
                        " beanDefinition = " + beanDefinition);
            }
        }

        /**
         * scope: 값이 생략이 되어있으면 singleton
         * abstract: false -> 추상 빈이 아니다. 추상 빈은 구체화되지 않아 직접 인스턴스화될 수 없다.
         * lazyInit: null -> 설정이 되지않음. 기본적으로 `false`이며, 컨테이너 시작 시 빈이 즉시 초기화된다.
         * autowireMode: 0 -> `NoAutowire`(자동 주입이 없음) 어떻게 의존성 주입이 이루어질지 결정
         * dependencyCheck: 0 -> 검사하지 않음. 객체의 속성에 대해 의존성 검사를 할지 여부
         * autowireCandidate: true -> 이 빈은 자동 주입의 대상이될 수 있다. 다른 빈들이 이 빈을 자동 주입 대상으로 고려할지를 결정한다.
         * primary: 같은 타입의 여러 빈 중 어떤 빈을 주입해야 할지 결정할때, 이 빈이 우선 순위를 가지는지 나타낸다.
         * factoryBeanName: 빈을 생성하기 위한 팩토리 빈의 이름
         * factoryMethodName: 빈을 생성하기 위해 사용되는 특정 메서드
         * initMethodName: 빈이 초기화될 때 호출될 메서드 이름
         * destroyMethodName: 빈이 소멸될 때 호출될 메서드의 이름
         */
    }
}
