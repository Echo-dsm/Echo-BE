package org.example.echo.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DUPLICATE_MEMBER(HttpStatus.BAD_REQUEST, "이미 존재하는 사용자입니다."),
    MEMBER_NOTFOUND(HttpStatus.NOT_FOUND, "사용자가 존재하지 않습니다.");

    private final HttpStatus status;
    private final String message;
}
