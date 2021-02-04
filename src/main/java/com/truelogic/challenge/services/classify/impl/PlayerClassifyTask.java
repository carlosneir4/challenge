package com.truelogic.challenge.services.classify.impl;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.factory.BasePlayerProcessFactory;

import java.util.concurrent.Callable;

/**
 * Class to represent Concurrent task.
 */
public class PlayerClassifyTask implements Callable<String> {


    PlayerInput player;
    BasePlayerProcessFactory playerProcess;

    public PlayerClassifyTask(PlayerInput player, BasePlayerProcessFactory playerProcess){
        this.player = player;
        this.playerProcess = playerProcess;
    }

    /**
     * Call to player process to classify a player.
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        return playerProcess.checkTypePlayer(player);
    }
}
