package com.fiap.beachsound.controller;

import com.fiap.beachsound.entity.Ong;
import com.fiap.beachsound.service.OngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ongs")
public class OngController {
    @Autowired
    private OngService ongService;

    @GetMapping
    public List<Ong> getAllOngs() {
        return ongService.getAllOngs();
    }

    @GetMapping("/{id}")
    public Ong getOngById(@PathVariable Long id) {
        return ongService.getOngById(id);
    }

    @PostMapping
    public void createOng(@RequestBody Ong ong) {
        ongService.saveOng(ong);
    }

    @PutMapping("/{id}")
    public void updateOng(@PathVariable Long id, @RequestBody Ong ong) {
        ong.setId(id);
        ongService.updateOng(ong);
    }

    @DeleteMapping("/{id}")
    public void deleteOng(@PathVariable Long id) {
        ongService.deleteOng(id);
    }
}
