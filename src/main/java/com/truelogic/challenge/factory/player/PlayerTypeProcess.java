package com.truelogic.challenge.factory.player;

import com.truelogic.challenge.domain.request.PlayerInput;

/**
 * Interface Player type process
 */
public abstract class PlayerTypeProcess {

    /**
     * method to process Player
     * @param player
     */
    public abstract void  process(PlayerInput player);

    /**
     * Method return the action was done by process method
     * @param name
     * @return
     */
    public abstract String actionProcess(String name);
}
