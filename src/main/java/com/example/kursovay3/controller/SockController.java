package com.example.kursovay3.controller;

import com.example.kursovay3.dto.SockRequest;
import com.example.kursovay3.exception.InSufficientSockQuantityException;
import com.example.kursovay3.exception.InvalidSockRequestException;
import com.example.kursovay3.model.Color;
import com.example.kursovay3.model.Size;
import com.example.kursovay3.service.SockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sock")
public class SockController {
    private final SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @ExceptionHandler(InvalidSockRequestException.class)
    public ResponseEntity<String> handleInvalidException(InvalidSockRequestException invalidSockRequestException) {
        return ResponseEntity.badRequest().body(invalidSockRequestException.getMessage());
    }

    @ExceptionHandler(InSufficientSockQuantityException.class)
    public ResponseEntity<String> handleInvalidException(InSufficientSockQuantityException invalidSockRequestException) {
        return ResponseEntity.badRequest().body(invalidSockRequestException.getMessage());
    }

    @PostMapping
    public void addSock(@RequestBody SockRequest sockRequest) {
        sockService.addSock(sockRequest);
    }

    @PutMapping
    public void issueSocks(@RequestBody SockRequest sockRequest) {
        sockService.issueSock(sockRequest);
    }

    @PostMapping
    public int getSocksCount(@RequestParam(required = false, name = "color")Color color,
                             @RequestParam(required = false, name = "size")Size size,
                             @RequestParam(required = false, name = "cottonMin")Integer cottonMin,
                             @RequestParam(required = false, name = "cottonMax")Integer cottonMax) {
        return sockService.getSockQuantity(color, size, cottonMin, cottonMax);
    }
}
