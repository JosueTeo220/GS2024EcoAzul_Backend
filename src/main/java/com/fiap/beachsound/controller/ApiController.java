package com.fiap.beachsound.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class ApiController {
    @GetMapping("/obter-praias")
    public ResponseEntity<String> obterPraias(){
        Path path = Path.of("C:\\Users\\josue\\Desktop\\Projetos FIAP\\beachsound\\src\\main\\java\\com\\fiap\\beachsound\\Praia.json");
        try{
            String conteudo = Files.readString(path);
            return ResponseEntity.ok(conteudo);
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
