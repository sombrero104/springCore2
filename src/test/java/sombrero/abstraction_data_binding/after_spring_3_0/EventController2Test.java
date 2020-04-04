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

/**
 * @WebMvcTest 애노테이션은 주로 컨트롤러와 같이 웹에 관련된 것들만 빈으로 등록이 됨.
 * 때문에 아래처럼 EventFormatter.class, EventController2.class를 빈으로 사용하겠다고 직접 추가해줘야 함.
 */
@RunWith(SpringRunner.class)
@WebMvcTest({EventFormatter.class, EventController2.class})
// @WebMvcTest({EventConverter.StringToEventConverter.class, EventController2.class})
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