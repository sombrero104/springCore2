package sombrero.abstraction_data_binding.after_spring_3_0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sombrero.abstraction_data_binding.before_spring_3_0.Event;

@RestController
public class EventController2 {

    /**
     * [데이터 바인딩]
     *
     * (1) Converter를 추가하는 방법.
     * 보통은 (2)번 처럼 자동으로 변환해주는 기능을 사용하지만
     * 스프링이 자동으로 변환해주지 않는 타입을 바인딩 할 때에는
     * 이와 같이 Converter를 추가해서 설정하는 방법을 사용.
     */
    @GetMapping("/after30/event/{event}")
    public String getEvent(@PathVariable Event event) {
        System.out.println("# [after_spring_3_0][EventController2] event: " + event);
        return event.getId().toString();
    }

    /**
     * (2) Converter를 추가하지 않는 방법.
     * 위의 방법처럼 Converter를 추가하지 않아도
     * 아래와 같이 타입(아래 예시에서는 Integer)을 지정해주면
     * 기본적으로 등록되어 있는 Converter와 Formatter들이 자동으로 변환해줌.
     */
    @GetMapping("/after30/event2/{id}")
    public String getEvent2(@PathVariable Integer id) {
        System.out.println("# [after_spring_3_0][EventController2] id: " + id);
        return id.toString();
    }

}
