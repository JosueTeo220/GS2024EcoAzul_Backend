package com.fiap.saveourshore.controller;

import com.fiap.saveourshore.model.Ong;
import com.fiap.saveourshore.service.OngService;
import com.fiap.saveourshore.service.PraiaService;
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
    @Autowired
    private OngService ongService;
    @Autowired
    private PraiaService praiaService;

    @PutMapping("/{id}/set-status-pendente")
    public ResponseEntity<String> setStatusPendente(@PathVariable Long id, @RequestParam boolean statusPendente) {
        try {
            Ong ong = ongService.getOngById(registroService.findById(id).getOng().getId());

            registroService.updateStatusPendente(id, statusPendente);
            praiaService.markPraiaAsLimpa(registroService.findById(id).getPraia().getId());
            ongService.updadeStatusAtuando(ong, false);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}