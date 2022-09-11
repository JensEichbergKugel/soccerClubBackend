package de.berufskollegaachen.soccerclubbackend.repository;

import de.berufskollegaachen.soccerclubbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
