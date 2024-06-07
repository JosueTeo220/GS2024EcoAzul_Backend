package com.fiap.saveourshore.controller;
import com.fiap.saveourshore.service.RegistroService;
import com.fiap.saveourshore.model.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/registro")
public class RegistroOngController {

    @Autowired
    private RegistroService registroService;

    @PutMapping("/{id}/set-ong/{ongId}")
    public ResponseEntity<String> setOngToRegistro(@PathVariable Long id, @PathVariable Long ongId) {
        try {
            registroService.assignOngToRegistro(id, ongId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

