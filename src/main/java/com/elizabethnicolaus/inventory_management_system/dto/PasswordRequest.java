package com.elizabethnicolaus.inventory_management_system.dto;

import jakarta.validation.constraints.*;

public record PasswordRequest(@NotBlank @Size(min = 8, max = 100) String newPassword) {}
