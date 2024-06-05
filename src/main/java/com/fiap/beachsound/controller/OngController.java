package com.fiap.beachsound.controller;

import com.fiap.beachsound.model.Ong;
import com.fiap.beachsound.service.OngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    private OngService ongService;

    @GetMapping
    public ResponseEntity<List<Ong>> getAllOngs() {
        try {
            List<Ong> ongs = ongService.getAllOngs();
            return ResponseEntity.ok(ongs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ong> getOngById(@PathVariable Long id) {
        try {
            Ong ong = ongService.getOngById(id);
            if (ong != null) {
                return ResponseEntity.ok(ong);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/atuando")
    public ResponseEntity<List<Ong>> getAllOngsAtuando() {
        try {
            List<Ong> ongs = ongService.getAllOngsAtuando();
            return ResponseEntity.ok(ongs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createOng(@RequestBody Ong ong) {
        try {
            ongService.saveOng(ong);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOng(@PathVariable Long id, @RequestBody Ong ong) {
        try {
            ong.setId(id);
            ongService.updateOng(ong);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOng(@PathVariable Long id) {
        try {
            ongService.deleteOng(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
