package com.elizabethnicolaus.inventory_management_system.controller;

import com.elizabethnicolaus.inventory_management_system.dto.*;
import com.elizabethnicolaus.inventory_management_system.service.UserService;
import com.elizabethnicolaus.inventory_management_system.entity.User;
import jakarta.validation.Valid;
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
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long userId ){
        return userService.getUserById(userId);
    }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public User creatUser(@RequestBody @Valid UserCreateRequest r){
        return userService.create(r);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody UserUpdateRequest r){
        return userService.update(userId, r);
    }
    @PatchMapping("/{id}/activate")
    public User activateUser(@PathVariable Long userId){
        return userService.setActive(userId,true);
    }
    @PatchMapping("{id}/deactivate")
    public User deactivatUser(@PathVariable Long userId){
        return userService.setActive(userId, false);
    }
    @PutMapping("{id}/password")@ResponseStatus(HttpStatus.NO_CONTENT)
    public void resetPassword(@PathVariable Long userId, @RequestBody  PasswordRequest r){
        userService.resetPassword(userId,r);
    }


}


