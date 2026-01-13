package org.example.echo.domain.BroadCast.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PostBroadCastRequestDTO(
        @NotBlank(message = "수정 메시지는 필수입니다.")
        String correctionMessage,
        @NotBlank(message = "원본 메시지는 필수입니다.")
        String originalMessage
) {

}