package de.berufskollegaachen.soccerclubbackend.controller;

import de.berufskollegaachen.soccerclubbackend.repository.TicketRepository;
import de.berufskollegaachen.soccerclubbackend.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepositories;

    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping("/qr")
    public ResponseEntity<byte[]> buyTicket() {

        //1. check if seats are available


        String contentToGenerateQrCode = "http://192.168.2.206:8080/ticket/";
        byte[] qrCode = qrCodeService.generateQrCode(contentToGenerateQrCode, 300, 300);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode);
    }

    @GetMapping("/")
    public String checkQrTicket() {
        return "Das Ticket ist Gültig";
    }
}
