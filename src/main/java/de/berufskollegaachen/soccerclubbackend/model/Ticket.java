package de.berufskollegaachen.soccerclubbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
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


    public Ticket(Integer gameId, Integer customerId, String block, Integer seatRow, Integer seat) {
        this.gameId = gameId;
        this.customerId = customerId;
        this.block = block;
        this.seatRow = seatRow;
        this.seat = seat;
    }
}

