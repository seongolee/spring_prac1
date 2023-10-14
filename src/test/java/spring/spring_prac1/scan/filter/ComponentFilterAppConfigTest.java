package spring.spring_prac1.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);

        // 빈이 등록이 되었는지 체크
        assertThat(beanA).isNotNull();
        // 빈이 등록되어 있지 않아 예외가 발생하는지 체크
        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class)
        );
    }

    @Configuration
    // FilterType 5가지 옵션
    // 1. ANNOTATION(default)
    // 2. ASSIGNABLE_TYPE -> 지정한 타입과 자식 타입을 인식해서 동작한다.
    //    ex) FilterType.ASSIGNABLE_TYPE, classes = BeanB.class
    // 3. ASPECTJ -> AspectJ 패턴 사용. ex) org.example.*Test+
    // 4. REGEX -> 정규 표현식
    // 5. CUSTOM -> TypeFilter 이라는 인터페이스를 구현해서 처리
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {
    }
}
