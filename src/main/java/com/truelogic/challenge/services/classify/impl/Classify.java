package com.truelogic.challenge.services.classify.impl;

import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.domain.response.ClassifyPlayersResponse;
import com.truelogic.challenge.factory.BasePlayerProcessFactory;
import com.truelogic.challenge.services.classify.ClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@Service
/**
 * Service Classify
 */
public class Classify implements ClassifyService {


    @Autowired
    BasePlayerProcessFactory playerProcess;

    @Override
    public ClassifyPlayersResponse classifyPlayers(List<PlayerInput> players) throws ExecutionException, InterruptedException {
        log.info("Start to classify players");

        ClassifyPlayersResponse response = new ClassifyPlayersResponse();
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<String> result = new ArrayList<>();
        for(PlayerInput player: players){
            Callable<String> callable = new PlayerClassifyTask(player,playerProcess);
            Future<String> future = service.submit(callable);
            result.add(future.get());
        }
        response.setResult(result);
        return response;
    }
}
