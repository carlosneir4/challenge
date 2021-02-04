package com.truelogic.challenge.factory.player.impl;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.entity.PlayerEntity;
import com.truelogic.challenge.factory.player.PlayerTypeProcess;
import com.truelogic.challenge.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Expert Player Class
 */
@Component
@Slf4j
public class ExpertPlayer extends PlayerTypeProcess {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void process(PlayerInput playerInput) {
        PlayerEntity player = new PlayerEntity(playerInput.getName(),playerInput.getType());
        playerRepository.save(player);
        log.info(String.format("#### -> Store player in DB -> %s", player.getName()));
    }

    @Override
    public String actionProcess(String name) {
        return String.format("Player %s stored in DB",name);
    }
}
