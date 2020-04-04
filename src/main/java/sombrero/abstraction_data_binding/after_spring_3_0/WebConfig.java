package sombrero.abstraction_data_binding.after_spring_3_0;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 이곳에서 추가한 Converter 또는 Formatter가 모든 컨트롤러에 동작.
 *
 * Converter와 Formatter를 아래처럼 registry에 추가하지 않고
 * 빈으로 등록해도 사용 가능하다. (보통은 registry에 등록하는 방법을 사용.)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        /**
         * (1) Converter 추가하는 방법.
         */
        // registry.addConverter(new EventConverter.StringToEventConverter());

        /**
         * (2) Formatter 추가하는 방법.
         */
        // registry.addFormatter(new EventFormatter());
    }

}
