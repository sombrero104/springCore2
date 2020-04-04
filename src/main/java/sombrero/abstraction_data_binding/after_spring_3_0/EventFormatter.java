package sombrero.abstraction_data_binding.after_spring_3_0;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

// @Component
public class EventFormatter implements Formatter<Event> {

    @Override
    public Event parse(String s, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(s));
    }

    @Override
    public String print(Event event, Locale locale) {
        return event.getId().toString();
    }

}
