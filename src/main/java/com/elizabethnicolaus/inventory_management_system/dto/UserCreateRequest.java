package com.elizabethnicolaus.inventory_management_system.dto;
import jakarta.validation.constraints.*;

public  record UserCreateRequest(
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9_.]{3,50}$",message ="3-50 Characters;letters,numbers,underscores or dot" ) String username,
    @NotBlank @Size (max = 50) String name,
    @NotBlank @Size(min = 8, max = 100,message = "Password should be at least 8 characters") String password,
    @NotNull Long roleId
) {}
