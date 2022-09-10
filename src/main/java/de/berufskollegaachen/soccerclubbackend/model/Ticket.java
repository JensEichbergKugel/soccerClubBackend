package de.berufskollegaachen.soccerclubbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

