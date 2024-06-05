package com.fiap.beachsound.controller;
import com.fiap.beachsound.entity.Praia;
import com.fiap.beachsound.service.PraiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/praias")
public class PraiaController {
    @Autowired
    private PraiaService praiaService;

    @GetMapping
    public List<Praia> getAllPraias() {
        return praiaService.getAllPraias();
    }

    @GetMapping("/poluida")
    public List<Praia> getPraiaPoluida(){
        return praiaService.getPraiaPoluida();
    }

    @GetMapping("/{id}")
    public Praia getPraiaById(@PathVariable Long id) {
        return praiaService.getPraiaById(id);
    }

    @PostMapping
    public void createPraia(@RequestBody Praia praia) {
        praiaService.savePraia(praia);
    }

    @PutMapping("/{id}")
    public void updatePraia(@PathVariable Long id, @RequestBody Praia praia) {
        praia.setId(id);
        praiaService.updatePraia(praia);
    }
    @DeleteMapping("/{id}")
    public void deletePraia(@PathVariable Long id) {
        praiaService.deletePraia(id);
    }

    @PutMapping("/poluida/{id}")
    public void markPraiaAsPoluida(@PathVariable Long id) {
        praiaService.markPraiaAsPoluida(id);
    }

    @PutMapping("/limpa/{id}")
    public void markPraiaAsLimpa(@PathVariable Long id) {
        praiaService.markPraiaAsLimpa(id);
    }
}
