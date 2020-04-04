package sombrero.abstraction_data_binding;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    /**
     * 컨트롤러에서 사용할 바인더를 등록하는 방법.
     */
    /*@InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Event.class, new EventEditor());
    }*/

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event) {
        System.out.println("# [EventController] event: " + event);
        return event.getId().toString();
    }

}
