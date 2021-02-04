package com.truelogic.challenge.services.classify;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.domain.response.ClassifyPlayersResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *Interface Classify Service
 */
public interface ClassifyService {

    /**
     * Method receive a list of player to be processed PlayerClassify task
     * return a List of results of each players.
     * @param players
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public ClassifyPlayersResponse classifyPlayers(List<PlayerInput> players) throws ExecutionException, InterruptedException;

}
