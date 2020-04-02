package sombrero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AppRunner2 implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * ApplicationContext가 ResourcePatternResolver를 상속받고
     * ResourcePatternResolver가 ResourceLoader를 상속받고 있다.
     * 때문에 ApplicationContext을 써도 되지만
     * ResourceLoader를 쓰는 것이 좀 더 명시적이므로 권장.
     */
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /**
         * 현재 사용중인 ApplicationContext를 알아낼 수 있다.
         *
         * 출력 결과:
         *   class org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
         */
        System.out.println("# ApplicationContext: " + applicationContext.getClass());

        /**
         * 현재 사용중인 Resource를 출력해보자.
         *
         * (1) 접두어 'classpath:'를 명시한 경우
         *
         * 출력 결과:
         *   class org.springframework.core.io.ClassPathResource
         */
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("# Resource(prefix 'classpath:'): " + resource.getClass());

        /**
         * (2) 접두어를 명시하지 않을 경우
         *
         * 출력 결과:
         *   class org.springframework.web.context.support.ServletContextResource
         */
        Resource resource2 = resourceLoader.getResource("test.txt");
        System.out.println("# Resource(no prefix): " + resource2.getClass());
    }

}
