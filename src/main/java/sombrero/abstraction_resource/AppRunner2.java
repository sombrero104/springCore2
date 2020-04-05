package sombrero.abstraction_resource;

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
        // System.out.println("# [abstraction_resource] ApplicationContext: " + applicationContext.getClass());

        /**
         * 현재 사용중인 Resource를 출력해보자.
         *
         * (1) 접두어 'classpath:'를 명시한 경우
         *
         * 출력 결과:
         *   class org.springframework.core.io.ClassPathResource
         */
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        // System.out.println("# [abstraction_resource] Resource(prefix 'classpath:'): " + resource.getClass());

        /**
         * (2) 접두어를 명시하지 않을 경우
         *
         * 출력 결과:
         *   class org.springframework.web.context.support.ServletContextResource
         */
        Resource resource2 = resourceLoader.getResource("test.txt");
        // System.out.println("# [abstraction_resource] Resource(no prefix): " + resource2.getClass());

        /**
         * ServletContextResource는 웹 애플리케이션 루트부터 찾는다. (context path)
         * 그런데 스프링부트의 내장형 톰캣에는 context path가 지정되어 있지 않다.
         * 따라서 리소스를 찾을 수가 없다. (exists가 false로 찍힘.)
         * 때문에 파일을 읽으려서 시도할 때 없는 파일을 읽으려고 하기 때문에 에러가 발생한다.
         * 때문에 'classpath:' 접두어를 사용하는 것을 권장.
         */
        /*System.out.println("# Resource(no prefix) exists: " + resource2.exists());
        System.out.println("# Resource(no prefix) description: " + resource2.getDescription());
        System.out.println("# Resource(no prefix) content: " + Files.readString(Path.of(resource2.getURI())));*/
        System.out.println();
    }

}
