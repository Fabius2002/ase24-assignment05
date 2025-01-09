package de.unibayreuth.se.taskboard.api.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

//TODO: Add DTO for users. (should be done)
public record UserDto(@Nullable UUID id,
                      @Nullable LocalDateTime createdAt,
                      @NotNull String name) {}
