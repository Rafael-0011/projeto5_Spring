package com.example.api.dto.desenvolvedorDto;

import io.swagger.v3.oas.annotations.media.Schema;

public record DesenvolvedorIdDto(
        @Schema(example = "1")
        Long id

) {

}
