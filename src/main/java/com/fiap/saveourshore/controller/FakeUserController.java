package com.fiap.saveourshore.controller;

import com.fiap.saveourshore.model.FakeUser;
import com.fiap.saveourshore.service.FakeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fakeuser")
public class FakeUserController {

    @Autowired
    private FakeUserService fakeUserService;

    @PostMapping("/verify")
    public ResponseEntity<Void> verifyFakeUser(@RequestBody FakeUser fakeUser) {
        try {
            FakeUser foundUser = fakeUserService.findByNome(fakeUser.getNome());
            if (foundUser != null && foundUser.getFakepassword().equals(fakeUser.getFakepassword())) {
                return ResponseEntity.status(HttpStatus.FOUND).build(); // 302 Found
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 401 Unauthorized
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
        }
    }
}
