package de.berufskollegaachen.soccerclubbackend.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "dateOfGame")
    LocalDateTime dateOfGame;

    @Column(name = "team")
    String team;

    @Column(name = "enemyTeam")
    String enemyTeam;

    @Column(name = "competition")
    String competition;

    @Column(name = "city")
    String city;

    @Column(name = "street")
    String street;

    @Column(name = "zip")
    String zip;

    @Column(name = "block")
    String block;

    @Column(name = "rowOfSeat")
    Integer rowOfSeat;

    @Column(name = "seat")
    Integer seat;
}

