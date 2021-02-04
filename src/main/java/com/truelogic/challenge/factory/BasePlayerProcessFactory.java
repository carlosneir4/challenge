package com.truelogic.challenge.factory;

import com.truelogic.challenge.domain.request.PlayerInput;

/**
 * Interface BasePlayerProcessFactory
 */
public interface BasePlayerProcessFactory {

    /**
     * Method calls a Process player according to player type, returns
     * the action was done by Process player.
     * @param player
     * @return
     */
    public abstract String checkTypePlayer(PlayerInput player);
}
