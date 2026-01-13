package org.example.echo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BOARD_LENGTH_OVER(HttpStatus.BAD_REQUEST, "방송 내용 길이가 255자 미만이어야 합니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "요청 형식이 잘못되었습니다."),
    EMPTY_MESSAGE_REQUEST(HttpStatus.BAD_REQUEST, "메시지가 없습니다"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String message;
}
