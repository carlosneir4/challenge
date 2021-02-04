package com.truelogic.challenge.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
/**
 * Class to represent output player
 */
public class ClassifyPlayersResponse {

    List<String> result;
}
