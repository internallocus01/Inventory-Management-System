package com.elizabethnicolaus.inventory_management_system.dto;
import jakarta.validation.constraints.*;

public record UserUpdateRequest(
    @NotBlank @Size (max = 50) String name,
    @NotNull Long roleId) {}
