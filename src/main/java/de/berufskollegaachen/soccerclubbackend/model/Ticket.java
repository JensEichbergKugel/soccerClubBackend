package de.berufskollegaachen.soccerclubbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Setter
@Getter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
    Integer id;

    @Column
    Integer gameId;

    @Column
    Integer customerId;

    @Column
    String block;

    @Column
    Integer seatRow;

    @Column
    Integer seat;

}

