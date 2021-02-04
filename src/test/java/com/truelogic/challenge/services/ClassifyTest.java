package com.truelogic.challenge.services;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.domain.response.ClassifyPlayersResponse;
import com.truelogic.challenge.factory.BasePlayerProcessFactory;
import com.truelogic.challenge.services.classify.ClassifyService;
import com.truelogic.challenge.services.classify.impl.Classify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClassifyTest {
    @Mock
    BasePlayerProcessFactory playerProcess;

    @InjectMocks
    Classify service;

    @Test
    void whenClassifyPlayersThenReturnResponse() throws ExecutionException, InterruptedException {
        List<PlayerInput> list= new ArrayList<>();
        PlayerInput player = new PlayerInput();
        player.setName("Carl");
        player.setType("expert");
        list.add(player);
        when(playerProcess.checkTypePlayer(player)).thenReturn("Player Sub zero stored in DB");
        ClassifyPlayersResponse response = service.classifyPlayers(list);
        assertThat(response.getResult().get(0)).isEqualTo("Player Sub zero stored in DB");
    }
}
