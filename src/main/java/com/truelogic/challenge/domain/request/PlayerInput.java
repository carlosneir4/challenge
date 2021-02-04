package com.truelogic.challenge.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Validated
/**
 * Class to represent input player
 */
public class PlayerInput {

    @JsonProperty("name")
    @NonNull
    private String name;

    @JsonProperty("type")
    private String type;

    public PlayerInput (String name, String type) {
        this.name=name;
        this.type=type;
    }
}
