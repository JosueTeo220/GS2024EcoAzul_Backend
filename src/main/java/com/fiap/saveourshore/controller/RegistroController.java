package com.fiap.saveourshore.controller;

import com.fiap.saveourshore.model.Registro;
import com.fiap.saveourshore.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping
    public ResponseEntity<List<Registro>> getAllRegistros() {
        try {
            List<Registro> registros = registroService.getAllRegistros();
            return ResponseEntity.ok(registros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro> getRegistroById(@PathVariable Long id) {
        try {
            Registro registro = registroService.findById(id);
            if (registro != null) {
                return ResponseEntity.ok(registro);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<Void> createRegistro(@RequestBody Registro registro) {
        try {
            if (registro.isValid()) {
                registroService.save(registro);
                registroService.updateStatusPendente(registro.getId(), true);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateRegistro(@PathVariable Long id, @Valid @RequestBody Registro registro) {
        try {
            registro.setId(id);
            registroService.update(registro);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistro(@PathVariable Long id) {
        try {
            registroService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
