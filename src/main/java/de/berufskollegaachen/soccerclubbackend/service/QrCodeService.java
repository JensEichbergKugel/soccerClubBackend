package de.berufskollegaachen.soccerclubbackend.service;

public interface QrCodeService {
    byte[] generateQrCode(String qrCodeContent, int width, int height);
}

