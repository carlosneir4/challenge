package com.truelogic.challenge.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Validated
/**
 * Class to represent List of Players
 */
public class ClassifyPlayersRequest {

    @NonNull
    List<PlayerInput> players;
}
