package de.berufskollegaachen.soccerclubbackend.repository;

import de.berufskollegaachen.soccerclubbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
}
