package com.fiap.saveourshore.controller;

import com.fiap.saveourshore.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class RegistroStatusController {

    @Autowired
    private RegistroService registroService;

    @PutMapping("/{id}/set-status-pendente")
    public ResponseEntity<String> setStatusPendente(@PathVariable Long id, @RequestParam boolean statusPendente) {
        try {
            registroService.updateStatusPendente(id, statusPendente);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}