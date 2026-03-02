package com.serralyse.website.controller;

import com.serralyse.website.dto.UserRegisterRequest;
import com.serralyse.website.entity.User;
import com.serralyse.website.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserRegisterRequest request){
        User savedUser = userService.registerUser(request);
        return ResponseEntity.ok(savedUser);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> allUsers = userService.listAll();
        return ResponseEntity.ok(allUsers);
    }
}
