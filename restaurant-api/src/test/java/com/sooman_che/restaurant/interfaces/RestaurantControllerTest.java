package com.sooman_che.restaurant.interfaces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))
           .andExpect(status().isOk())
           .andExpect(content().string(
                   containsString("\"id\":1004")
           ))
           .andExpect(content().string(
                   containsString("\"name\":\"Bob zip\"")
           ));
    }

}