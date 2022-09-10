package de.berufskollegaachen.soccerclubbackend.controller;

import de.berufskollegaachen.soccerclubbackend.model.Ticket;
import de.berufskollegaachen.soccerclubbackend.repository.TicketRepository;
import de.berufskollegaachen.soccerclubbackend.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepositories;

    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping("/buy/{gameId}")
    public ResponseEntity<byte[]> buyTicket(@PathVariable(value = "gameId") Integer gameId) {


        Optional<Ticket> optionalTicket = ticketRepositories.findById(gameId);

        String contentToGenerateQrCode = "http://192.168.2.206:8080/ticket/";
        byte[] qrCode = qrCodeService.generateQrCode(contentToGenerateQrCode, 300, 300);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode);
    }

    @GetMapping("/")
    public String checkQrTicket() {
        return "Das Ticket ist Gültig";
    }
}
