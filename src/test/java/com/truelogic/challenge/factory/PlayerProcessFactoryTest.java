package com.truelogic.challenge.factory;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.factory.player.PlayerTypeProcess;
import com.truelogic.challenge.factory.player.impl.ExpertPlayer;
import com.truelogic.challenge.factory.player.impl.NovicePlayer;
import com.truelogic.challenge.factory.player.impl.UnknownLevelPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerProcessFactoryTest {

    @Mock
    PlayerTypeProcess playerType;

    @Mock
    ExpertPlayer expert;

    @Mock
    NovicePlayer novice;

    @Mock
    UnknownLevelPlayer unknownlevel;

    @InjectMocks
    PlayerProcessFactory factory;

    @Test
    void whenPlayerIsExpertThenReturnExpertPlayerAction() throws ExecutionException, InterruptedException {
        PlayerInput player = new PlayerInput();
        player.setName("Carl");
        player.setType("expert");
        when(expert.actionProcess(player.getName())).thenReturn("Player Carl stored in DB");
        String action = factory.checkTypePlayer(player);
        assertThat(action).isEqualTo("Player Carl stored in DB");
    }

    @Test
    void whenPlayerIsNoviceThenReturnNovicePlayerAction() throws ExecutionException, InterruptedException {
        PlayerInput player = new PlayerInput();
        player.setName("mark");
        player.setType("novice");
        when(novice.actionProcess(player.getName())).thenReturn("Player mark sent to Kafka topic");
        String action = factory.checkTypePlayer(player);
        assertThat(action).isEqualTo("Player mark sent to Kafka topic");
    }

    @Test
    void whenPlayerIsUknownlevelThenReturnUnknownPlayerAction() throws ExecutionException, InterruptedException {
        PlayerInput player = new PlayerInput();
        player.setName("john");
        player.setType("smart");
        when(unknownlevel.actionProcess(player.getName())).thenReturn("Player john did not fit in any category");
        String action = factory.checkTypePlayer(player);
        assertThat(action).isEqualTo("Player john did not fit in any category");
    }

    @Test
    void whenPlayerIsNullThenReturnDefaultPlayerAction() throws ExecutionException, InterruptedException {
        PlayerInput player = new PlayerInput();
        player.setName("xxx");
        String action = factory.checkTypePlayer(player);
        assertThat(action).isEqualTo("Player xxx has not a valid type");
    }
}
