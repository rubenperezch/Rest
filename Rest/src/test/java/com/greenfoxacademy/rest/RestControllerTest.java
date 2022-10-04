package com.greenfoxacademy.rest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void POSTresponseArrayHandlerAndParameter() throws Exception{

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(1);
        jsonArray.put(2);
        jsonArray.put(5);
        jsonArray.put(10);
        jsonObject.put("what","sum");
        jsonObject.put("numbers",jsonArray);

        mockMvc.perform(post("/arrays")
                        .content(String.valueOf(jsonObject))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",is(18))
                );

    }

    @Test
    public void POSTresponseGrootServiceSendsStatusNoParameter() throws Exception{

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(1);
        jsonArray.put(2);
        jsonArray.put(5);
        jsonArray.put(10);
        //jsonObject.put("what","sum");
        jsonObject.put("numbers",jsonArray);

        mockMvc.perform(post("/groot")
                        .content(String.valueOf(jsonObject))
                        .contentType("application/json"))
                .andExpect(status().is(404))
                .andExpect(jsonPath("$.error",is("Please provide what to do with the numbers!"))
                );

    }
}
