package sombrero.abstraction_validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class AppRunner4 implements ApplicationRunner {

    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /**
         * 출력 결과:
         *      class org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
         */
        System.out.println("# [abstractio_validation][AppRunner4] validator: " + validator.getClass());

        /**
         * Event2에 애노테이션으로 검증해야 할 내용을 설정해준다.
         */
        Event2 event2 = new Event2();
        event2.setLimit(-1);
        event2.setEmail("hm..");
        Errors errors = new BeanPropertyBindingResult(event2, "event");
        validator.validate(event2, errors);

        System.out.println("# [abstractio_validation][AppRunner4] hasErrors: " + errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("============== [AppRunner4] error code ==============");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println("# message: " + e.getDefaultMessage());
        });
        System.out.println("=====================================================");
    }

}
