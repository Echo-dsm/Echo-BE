package org.example.echo.global.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.echo.global.exception.CustomException;
import org.example.echo.global.exception.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 모든 Exception 처리 → INTERNAL_SERVER_ERROR로 응답
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("서버 내부 오류 발생", e);

        ErrorResponse response = new ErrorResponse(
                ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value(),
                ErrorCode.INTERNAL_SERVER_ERROR.getMessage()
        );

        return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .body(response);
    }

    // 커스텀 예외 처리 예시
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorCode code = e.getErrorCode();
        log.warn("예외 발생: {}", code.getMessage());

        ErrorResponse response = new ErrorResponse(code.getStatus().value(), code.getMessage());
        return ResponseEntity.status(code.getStatus()).body(response);
    }

    // 잘못된 인자값 잡기
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ErrorResponse response = new ErrorResponse(ErrorCode.BOARD_LENGTH_OVER.getStatus().value(), message);

        return new ResponseEntity<>(response, ErrorCode.BOARD_LENGTH_OVER.getStatus());
    }

    @Getter
    @AllArgsConstructor
    static class ErrorResponse {
        private final int status;
        private final String message;
    }
}
