package com.truelogic.challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
/**
 * Entity Player
 */
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;

    public PlayerEntity(String name, String type){
        this.name=name;
        this.type=type;
    }

    protected PlayerEntity() { }
}
