package com.elizabethnicolaus.inventory_management_system.service;

import com.elizabethnicolaus.inventory_management_system.dto.PasswordRequest;
import com.elizabethnicolaus.inventory_management_system.dto.UserCreateRequest;
import com.elizabethnicolaus.inventory_management_system.dto.UserUpdateRequest;
import com.elizabethnicolaus.inventory_management_system.entity.User;
import com.elizabethnicolaus.inventory_management_system.exception.BusinessRuleException;
import com.elizabethnicolaus.inventory_management_system.exception.ResourceNotFoundException;
import com.elizabethnicolaus.inventory_management_system.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    //private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() { 
        return userRepository.findAll(); 
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
    }
    
    public User create(UserCreateRequest r) {
        if (userRepository.existsByUsername(r.username()))
            throw new BusinessRuleException("Username already taken");
        User u = new User();
        u.setUsername(r.username());
        u.setName(r.name());
        u.setPasswordHash(passwordEncoder.encode(r.password()));
        //u.setRole(roleService.get(r.roleId()));
        return userRepository.save(u);
    }

    @Transactional
    public User update(Long id, UserUpdateRequest r) {
        User u = getUserById(id);
        u.setName(r.name()); 
        //u.setRole(roleService.get(r.roleId()));
        return userRepository.save(u);
    }

    public User setActive(Long id, boolean active) { 
        User u = getUserById(id);
        u.setIsActive(active);
        return userRepository.save(u);
    }

    public void resetPassword(Long id, PasswordRequest r) {
        User u = getUserById(id);
        u.setPasswordHash(passwordEncoder.encode(r.newPassword()));
        userRepository.save(u);
    }
}
