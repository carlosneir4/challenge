package com.truelogic.challenge.controllers;


import com.truelogic.challenge.domain.request.ClassifyPlayersRequest;
import com.truelogic.challenge.domain.response.ClassifyPlayersResponse;
import com.truelogic.challenge.services.classify.ClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * Player Controller exposes Player methods
 */
@Slf4j
@RestController
@RequestMapping("player")
@Validated
@ResponseBody
public class PlayerController {

    @Autowired
    private ClassifyService classifyService;

    /**
     * Method to classify Players according to type
     */
    @PostMapping(value="/classify")
    public ClassifyPlayersResponse classify(@RequestBody ClassifyPlayersRequest request) throws ExecutionException, InterruptedException {
        return classifyService.classifyPlayers(request.getPlayers());
    }


}
