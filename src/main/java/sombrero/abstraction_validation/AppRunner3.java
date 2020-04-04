package sombrero.abstraction_validation;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

@Component
public class AppRunner3 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Event event = new Event();
        EventValidator eventValidator = new EventValidator();
        System.out.println("# [abstractio_validation][AppRunner3] eventValidator: " + eventValidator.getClass());

        /**
         * 스프링 MVC에서는
         * 자동으로 BeanPropertyBindingResult를 Errors 인터페이스 타입으로 넘겨주기 때문에
         * 아래처럼 직접 선언해서 사용하는 경우는 없음.
         */
        Errors errors = new BeanPropertyBindingResult(event, "event");
        eventValidator.validate(event, errors);

        System.out.println("# [abstractio_validation][AppRunner3] hasErrors: " + errors.hasErrors());

        /**
         * 아래 출력결과에서 기존에 추가했던 에러코드인 'notempty' 외에도
         * 'notempty.event.title', 'notempty.title', 'notempty.java.lang.String'
         * 에러코드가 자동으로 추가된 것을 확인할 수 있다. (스프링에서 자동으로 에러코드를 추가해줌.)
         *
         * 출력 결과:
         *
         *      ============== error code ==============
         *      notempty.event.title
         *      notempty.title
         *      notempty.java.lang.String
         *      notempty
         *      # message: Empty title is not allowed.
         */
        errors.getAllErrors().forEach(e -> {
            System.out.println("============== error code ==============");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println("# message: " + e.getDefaultMessage());
        });
        System.out.println("========================================");
    }

}
