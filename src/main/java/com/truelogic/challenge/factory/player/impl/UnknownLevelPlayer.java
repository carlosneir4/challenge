package com.truelogic.challenge.factory.player.impl;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.factory.player.PlayerTypeProcess;
import org.springframework.stereotype.Component;

/**
 * Uknnown Level Player Class
 */
@Component
public class UnknownLevelPlayer extends PlayerTypeProcess {

    @Override
    public void process(PlayerInput player) {
        // do_nothing
    }

    @Override
    public String actionProcess(String name) {
        return String.format("Player %s did not fit in any category",name);
    }
}
