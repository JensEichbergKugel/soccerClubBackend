package de.berufskollegaachen.soccerclubbackend.repository;

import de.berufskollegaachen.soccerclubbackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
