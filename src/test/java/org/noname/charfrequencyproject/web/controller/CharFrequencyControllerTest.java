package org.noname.charfrequencyproject.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.noname.charfrequencyproject.service.CharFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CharFrequencyControllerTest {
    private static final String POST__CALCULATE_FREQUENCY = "/api/charFrequency/calculateFrequency";


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CharFrequencyService frequencyService;

    @Test
    public void getCharFrequencyFromString_string_okResponseWithExceptedValues() throws Exception {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("inputString", "aaaaabcccc");

        ResultActions result = mockMvc.perform(post(POST__CALCULATE_FREQUENCY)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody))
        );

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isSuccess").value(true))
                .andExpect(jsonPath("$.result.a").value(5))
                .andExpect(jsonPath("$.result.c").value(4))
                .andExpect(jsonPath("$.result.b").value(1))
                .andExpect(jsonPath("$.error").value(IsNull.nullValue()));
    }

    @Test
    public void getCharFrequencyFromString_noInputString_badRequestExcepted() throws Exception {
        Map<String, String> requestBody = new HashMap<>();

        ResultActions result = mockMvc.perform(post(POST__CALCULATE_FREQUENCY)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody))
        );

        result.andExpect(status().isBadRequest())
                .andExpect(status().reason("'inputString' parameter must be passed in request body."));
    }
}