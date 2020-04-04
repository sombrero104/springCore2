package sombrero.abstraction_data_binding.after_spring_3_0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class AppRunner5 implements ApplicationRunner {

    /**
     * 스프링부트에서는
     * 웹 애플리케이션인 경우에 DefaultFormattingConversionService를 상속하여 만든
     * WebConversionService를 빈으로 등록해준다.
     * (직접 이 빈을 가져와서 사용할 일은 거의 없다. 지금은 그냥 테스트를 위해 사용중.)
     */
    @Autowired
    ConversionService conversionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("# [after_spring_3_0][AppRunner5] conversionService: " + conversionService.getClass().toString());
    }

}
