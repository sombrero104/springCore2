package sombrero.abstraction_data_binding.after_spring_3_0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sombrero.abstraction_data_binding.before_spring_3_0.Event;

@RestController
public class EventController2 {

    @GetMapping("/after30/event/{event}")
    public String getEvent(@PathVariable Event event) {
        System.out.println("# [after_spring_3_0][EventController2] event: " + event);
        return event.getId().toString();
    }

}
