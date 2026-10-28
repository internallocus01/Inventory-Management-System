package com.elizabethnicolaus.inventory_management_system.controller;

import com.elizabethnicolaus.inventory_management_system.dto.*;
import com.elizabethnicolaus.inventory_management_system.service.UserService;
import com.elizabethnicolaus.inventory_management_system.entity.User;
import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController 
@RequestMapping("/api/users")

public class UserController{
    private final UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping 
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    
}


