package com.truelogic.challenge.factory;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.factory.player.PlayerTypeProcess;
import com.truelogic.challenge.factory.player.impl.ExpertPlayer;
import com.truelogic.challenge.factory.player.impl.NovicePlayer;
import com.truelogic.challenge.factory.player.impl.UnknownLevelPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerProcessFactory implements BasePlayerProcessFactory{


    PlayerTypeProcess playerType;

    @Autowired
    ExpertPlayer expert;

    @Autowired
    NovicePlayer novice;

    @Autowired
    UnknownLevelPlayer unknownlevel;



    @Override
    public String checkTypePlayer(PlayerInput player) {

        if (player.getType() == null) {
            return String.format("Player %s has not a valid type", player.getName());
        }
        if (player.getType().equalsIgnoreCase("EXPERT")) {
            playerType = expert;

        } else if (player.getType().equalsIgnoreCase("NOVICE")) {
            playerType = novice;

        } else {
            playerType = unknownlevel;
        }
        playerType.process(player);
        return playerType.actionProcess(player.getName());
    }
}

