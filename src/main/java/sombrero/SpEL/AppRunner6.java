package sombrero.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner6 implements ApplicationRunner {

    /**
     * SpEL
     *
     * @Value() 에 단순한 값을 적어도 되고,
     * '#{}'를 사용하면 표현식으로 인식한다.
     * '${}'는 프로퍼티를 참고하는 방법이다.
     */

    @Value("#{1 + 1}")
    int value;

    @Value("#{'hello ' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("hello")
    String hello;

    @Value("${my.value}")
    int myValue;

    @Value("#{${my.value} eq 100}")
    boolean isMyValue100;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("============== [SpEL][AppRunner6] ==============");
        System.out.println("# [SpEL][AppRunner6] value: " + value);
        System.out.println("# [SpEL][AppRunner6] greeting: " + greeting);
        System.out.println("# [SpEL][AppRunner6] trueOrFalse: " + trueOrFalse);
        System.out.println("# [SpEL][AppRunner6] hello: " + hello);
        System.out.println("# [SpEL][AppRunner6] myValue: " + myValue);
        System.out.println("# [SpEL][AppRunner6] isMyValue100: " + isMyValue100);
        System.out.println("================================================");
    }

}
