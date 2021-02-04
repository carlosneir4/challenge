package com.truelogic.challenge.controllers;

import com.truelogic.challenge.domain.request.ClassifyPlayersRequest;
import com.truelogic.challenge.domain.request.PlayerInput;
import com.truelogic.challenge.domain.response.ClassifyPlayersResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestPlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    ClassifyPlayersRequest players;
    List<PlayerInput> list;
    HttpHeaders headers;


    @BeforeEach
    public void setUp() throws Exception {
        players = new ClassifyPlayersRequest();
        headers = new HttpHeaders();
    }


    @Test
    public void whenValidPlayerInputThenReturnResultList() throws Exception {

        list = new ArrayList<PlayerInput>();
        list.add(new PlayerInput("name1","expert"));
        list.add(new PlayerInput("name2","novice"));
        list.add(new PlayerInput("name3","novice"));
        list.add(new PlayerInput("name4","expert"));
        list.add(new PlayerInput("name5","other"));
        list.add(new PlayerInput("name6","expert"));
        list.add(new PlayerInput("name7","novice"));
        list.add(new PlayerInput("name8","other"));
        players.setPlayers(list);
        final String baseUrl = "http://localhost:" + port + "/player/classify";
        URI uri = new URI(baseUrl);

        HttpEntity<ClassifyPlayersRequest> request = new HttpEntity<>(players, headers);
        ResponseEntity<ClassifyPlayersResponse> result = restTemplate.postForEntity(uri,request, ClassifyPlayersResponse.class);

        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getResult().size()).isEqualTo(players.getPlayers().size());
    }

    @Test
    public void whenNullPlayerListInputThenReturnBadRequest() throws Exception {

        final String baseUrl = "http://localhost:" + port + "/player/classify";
        URI uri = new URI(baseUrl);
        HttpEntity<ClassifyPlayersRequest> request = new HttpEntity<>(players, headers);
        ResponseEntity<ClassifyPlayersResponse> result = restTemplate.postForEntity(uri,request, ClassifyPlayersResponse.class);

        assertThat(result.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void whenEmptyPlayerListInputThenReturnEmptyResult() throws Exception {

        players.setPlayers(new ArrayList<PlayerInput>());
        final String baseUrl = "http://localhost:" + port + "/player/classify";
        URI uri = new URI(baseUrl);

        HttpEntity<ClassifyPlayersRequest> request = new HttpEntity<>(players, headers);
        ResponseEntity<ClassifyPlayersResponse> result = restTemplate.postForEntity(uri,request, ClassifyPlayersResponse.class);

        assertThat(result.getBody().getResult()).isEmpty();
    }
}
