package sombrero.abstraction_data_binding.after_spring_3_0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventController2Test {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getTest2() throws Exception {
        mockMvc.perform(get("/after30/event/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

}