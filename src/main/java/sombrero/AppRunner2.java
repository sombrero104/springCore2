package sombrero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner2 implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /**
         * 현재 사용중인 ApplicationContext를 알아낼 수 있다.
         *
         * 출력 결과:
         *   class org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
         */
        System.out.println("# ApplicationContext: " + applicationContext.getClass());
    }

}
