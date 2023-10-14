package spring.spring_prac1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 컴포넌트를 읽을 시작 위치를 지정
        basePackages = "spring.spring_prac1",

        // AutoAppConfig.class가 속한 package가 시작 위치로 지정된다.
        basePackageClasses = AutoAppConfig.class,

        // basePackages, basePackageClasses 값이 지정이 되어있지 않으면 default 값으로 @Configuration을
        // 선언한 AutoAppConfig.class의 package 경로가 시작 위치가 된다.

        // 테스트를 위해서 Appconfig에 지정된 설정을 제외한다.
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class
        )

)
public class AutoAppConfig {
}
