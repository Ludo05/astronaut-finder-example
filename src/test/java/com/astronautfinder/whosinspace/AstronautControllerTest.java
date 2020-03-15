package com.astronautfinder.whosinspace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class AstronautControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void GetAstronautNamesTest() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders
      .get("/astronauts/all/ordered")
      .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(content().string("[{\"craft\":\"ISS\",\"name\":\"Jessica Meir\",\"lastName\":\"Meir\"},{\"craft\":\"ISS\",\"name\":\"Andrew Morgan\",\"lastName\":\"Morgan\"},{\"craft\":\"ISS\",\"name\":\"Oleg Skripochka\",\"lastName\":\"Skripochka\"}]"));

    }
}
