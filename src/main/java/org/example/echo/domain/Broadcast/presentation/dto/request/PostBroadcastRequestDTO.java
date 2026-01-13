package org.example.echo.domain.Broadcast.presentation.dto.request;


public record PostBroadcastRequestDTO(
        String correctionMessage,
        String originalMessage
) {
}