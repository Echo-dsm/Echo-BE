package org.example.echo.domain.Broadcast.presentation.dto.request;

public record PostBroadcastRequestDTO(
        String API_KEY,
        String correctionMessage,
        String originalMessage
) {
}