package com.pinsoft.challenge.controller;

import com.pinsoft.challenge.dto.ExpressionDTO;
import com.pinsoft.challenge.dto.MinesweeperDTO;
import com.pinsoft.challenge.dto.RPNCalculatorDTO;
import com.pinsoft.challenge.service.RPNCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.pinsoft.challenge.controller.Util.asJsonString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class RPNCalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RPNCalculatorService rpnCalculatorService;

    @Test
    void shouldReturnResponse() throws Exception {
        ExpressionDTO expressionDTO = new ExpressionDTO();
        expressionDTO.setExpression("3 5 8 * 7 + *");

        when(rpnCalculatorService.calculateRPN(any())).thenReturn(new RPNCalculatorDTO(141));

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(expressionDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"result\": 141}"));
    }
}