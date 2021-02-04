package com.truelogic.challenge.repository;

import com.truelogic.challenge.entity.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    PlayerRepository repository;
    @Test
    public void it_should_save_player() {
        PlayerEntity player = new PlayerEntity("carl","expert");
        repository.save(player);
        assertThat(repository.findAll().size()).isEqualTo(1);
    }
}