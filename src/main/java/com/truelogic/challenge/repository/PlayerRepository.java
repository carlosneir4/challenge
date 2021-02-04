package com.truelogic.challenge.repository;

import com.truelogic.challenge.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Repository of Player
 */
@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {
}
