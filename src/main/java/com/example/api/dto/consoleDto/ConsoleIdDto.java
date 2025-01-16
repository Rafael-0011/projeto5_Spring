package com.example.api.dto.consoleDto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ConsoleIdDto(
        @Schema(example = "1")
        Long id
) {
}
