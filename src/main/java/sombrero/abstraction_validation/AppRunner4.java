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
        System.out.println("# [abstractio_validation][AppRunner4] validator: " + validator.getClass());

        Event event = new Event();
        Errors errors = new BeanPropertyBindingResult(event, "event");
        validator.validate(event, errors);

        System.out.println("# [abstractio_validation][AppRunner4] hasErrors: " + errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("============== error code ==============");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println("# message: " + e.getDefaultMessage());
        });
        System.out.println("========================================");
    }

}
