package sombrero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        System.out.println("# test.txt exists: " + resource.exists());
        System.out.println("# test.txt description" + resource.getDescription());
        System.out.println("# test.txt content: " + Files.readString(Path.of(resource.getURI())));

        /**
         * [Resource 인터페이스 둘러보기]
         *
         * getInputStream()
         * exist()
         * isOpen()
         * getDescription(): 전체 경로 포함한 파일 이름 또는 실제 URL.
         */

        /**
         * [Resource 구현체]
         *
         * (1) UrlResource: java.net.URL 참고, 기본으로 지원하는 프로토콜 http, https, ftp, file, jar.
         * (2) ClassPathResource: 지원하는 접두어 'classpath:'
         * (3) FileSystemResource
         * (4) ServletContextResource: 웹 애플리케이션 루트에서 상대 경로로 리소스 찾는다.
         */

        /** [리소스 읽어오기]
         * Resource의 타입은 location 문자열과 ApplicationContext의 타입에 따라 결정된다.
         *
         * ● ClassPathXmlApplicationContext -> ClassPathResource
         * ● FileSystemXmlApplication -> FileSystemResource
         * ● WebApplicationContext -> ServletContextResource
         *
         * ApplicationContext의 타입에 상관없이 리소스 타입을 강제하려면
         *      java.net.URL의 접두어 혹은 'classpath:'를 사용할 수 있다.
         *
         * ● classpath:sombrero/config.xml -> ClassPathResource
         * ● file:///sombrero/config.xml -> FileSystemResource
         */

        var ctx = new ClassPathXmlApplicationContext("test.xml");
        /**
         * 위의 test.xml는 추상화된 ClassPathResource로 내부적으로 변환이 된다.
         * ClassPathXmlApplicationContext는 클래스패스를 기준으로 리소스를 찾는다.
         * 위의 test.xml는 'classpath:test.xml'과 같다.
         */

        var ctx2 = new FileSystemXmlApplicationContext("test.xml");
        /**
         * 위의 test.xml는 추상화된 FileSystemResource로 내부적으로 변환이 된다.
         * FileSystemXmlApplicationContext는 파일시스템 기준으로 리소스를 찾는다.
         */

    }

}
