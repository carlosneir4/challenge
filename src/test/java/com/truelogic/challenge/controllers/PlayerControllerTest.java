package com.truelogic.challenge.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.truelogic.challenge.domain.request.ClassifyPlayersRequest;
import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.domain.response.ClassifyPlayersResponse;
import com.truelogic.challenge.services.classify.ClassifyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = PlayerController.class)
@ActiveProfiles("test")
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClassifyService classifyService;

    ClassifyPlayersRequest players;
    List<PlayerInput> list;

    @BeforeEach
    void setUp (){
        players = new ClassifyPlayersRequest();
        list = new ArrayList<>();
        PlayerInput player = new PlayerInput();
        player.setName("Carl");
        player.setType("expert");
        list.add(player);
        players.setPlayers(list);
    }


    @Test
    public void whenValidPlayerInputThenReturnStatusOk() throws Exception {
        ClassifyPlayersResponse result = new ClassifyPlayersResponse();
        result.setResult(Arrays.asList("Player Sub zero stored in DB"));
        given(classifyService.classifyPlayers(list)).willReturn(result);
        mockMvc.perform(post("/player/classify")
                .contentType("application/json").content(objectMapper.writeValueAsString(players)))
                .andExpect(status().isOk());
    }


    @Test
    public void whenNullPlayerListInputThenReturnBadRequest() throws Exception {
        ClassifyPlayersRequest nullPlayers = new ClassifyPlayersRequest();
        mockMvc.perform(post("/player/classify")
        .contentType("application/json").content(objectMapper.writeValueAsString(nullPlayers)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenEmptyPlayerListInputThenReturnEmptyResult() throws Exception {
        ClassifyPlayersRequest emptyPlayers = new ClassifyPlayersRequest();
        emptyPlayers.setPlayers(new ArrayList<PlayerInput>());
        MvcResult mvcResult = mockMvc.perform(post("/player/classify")
                .contentType("application/json").content(objectMapper.writeValueAsString(emptyPlayers)))
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEmpty();
    }


}
