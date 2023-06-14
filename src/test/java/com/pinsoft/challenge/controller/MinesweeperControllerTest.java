package com.pinsoft.challenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinsoft.challenge.dto.MinesweeperDTO;
import com.pinsoft.challenge.dto.SquareDTO;
import com.pinsoft.challenge.service.MinesweeperService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.pinsoft.challenge.controller.Util.asJsonString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class MinesweeperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MinesweeperService minesweeperService;

    @Test
    void shouldReturnResponse() throws Exception {
        String[] square =  new String[] {"**...",".....",".*..."};
        SquareDTO squareDTO = new SquareDTO();
        squareDTO.setSquare(square);


        when(minesweeperService.getHints(any())).thenReturn(new MinesweeperDTO(new String[] {"**100","33200","1*100"}));

        mockMvc.perform(post("/show-hints")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(squareDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"hints\": [\"**100\",\"33200\",\"1*100\"]}"));

    }


}