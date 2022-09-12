package de.berufskollegaachen.soccerclubbackend.controller;

import de.berufskollegaachen.soccerclubbackend.model.Ticket;
import de.berufskollegaachen.soccerclubbackend.repository.TicketRepository;
import de.berufskollegaachen.soccerclubbackend.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepositories;

    @Autowired
    private QrCodeService qrCodeService;

    @PostMapping("/buy/{gameId}")
    public ResponseEntity<byte[]> buyTicket(@PathVariable(value = "gameId") Integer gameId,
                                            @RequestParam(required = false, name = "block") String block,
                                            @RequestParam(required = false, name = "seatRow") Integer seatRow,
                                            @RequestParam(required = false, name = "seat") Integer seat) {

        Optional<Ticket> optionalTicket = ticketRepositories.findByGameIdAndBlockAndSeatRowAndSeat(gameId, block, seatRow, seat);

        if (optionalTicket.isEmpty()) {
            Ticket newTicket = new Ticket(gameId, 1, block, seatRow, seat);
            Ticket boughtTicket = ticketRepositories.save(newTicket);

            String contentToGenerateQrCode = "http://192.168.2.206:8080/ticket/" + boughtTicket.getId();
            byte[] qrCode = qrCodeService.generateQrCode(contentToGenerateQrCode, 300, 300);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode);
        }

        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "No available ticket found for the requested parameter");
    }

    @GetMapping("/{ticketId}")
    public Ticket checkQrTicket(@PathVariable(value = "ticketId") Integer ticketId) {
        return ticketRepositories.findById(ticketId).orElseThrow(NoSuchElementException::new);
    }
}
