package spring.spring_prac1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 컴포넌트를 읽을 시작 위치를 지정
        basePackages = "spring.spring_prac1",
        // 테스트를 위해서 Appconfig에 지정된 설정을 제외한다.
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class
        )

)
public class AutoAppConfig {
}
