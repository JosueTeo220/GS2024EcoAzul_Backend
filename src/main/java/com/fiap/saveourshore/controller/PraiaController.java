package com.fiap.saveourshore.controller;

import com.fiap.saveourshore.model.Praia;
import com.fiap.saveourshore.service.PraiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/praias")
public class PraiaController {

    @Autowired
    private PraiaService praiaService;

    @GetMapping
    public ResponseEntity<List<Praia>> getAllPraias() {
        try {
            List<Praia> praias = praiaService.getAllPraias();
            return ResponseEntity.ok(praias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/poluida")
    public ResponseEntity<List<Praia>> getPraiaPoluida() {
        try {
            List<Praia> praias = praiaService.getPraiaPoluida();
            return ResponseEntity.ok(praias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Praia> getPraiaById(@PathVariable Long id) {
        try {
            Praia praia = praiaService.getPraiaById(id);
            if (praia != null) {
                return ResponseEntity.ok(praia);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createPraia(@RequestBody Praia praia) {
        try {
            praiaService.savePraia(praia);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePraia(@PathVariable Long id, @RequestBody Praia praia) {
        try {
            praia.setId(id);
            praiaService.updatePraia(praia);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePraia(@PathVariable Long id) {
        try {
            praiaService.deletePraia(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/poluida/{id}")
    public ResponseEntity<Void> markPraiaAsPoluida(@PathVariable Long id) {
        try {
            praiaService.markPraiaAsPoluida(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/limpa/{id}")
    public ResponseEntity<Void> markPraiaAsLimpa(@PathVariable Long id) {
        try {
            praiaService.markPraiaAsLimpa(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/count")
    public ResponseEntity<Long> getPraiaCount() {
        try {
            long count = praiaService.countPraias();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
