package com.enigma.testauth.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;


public record UserEntityDto(
        String name,
        String password,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}