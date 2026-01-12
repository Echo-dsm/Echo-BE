package org.example.echo.global.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.echo.global.exception.CustomException;
import org.example.echo.global.p.ErrorResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    // 1. 반환 타입을 ResponseEntity<ErrorResponseEntity>로 변경합니다.
    // 이렇게 하면 스프링이 내부적으로 Jackson 라이브러리를 써서 객체를 JSON 문자열로 자동 변환합니다.
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException e) {

        // 2. 수동으로 jsonFormat을 호출할 필요 없이 객체를 body에 바로 담습니다.
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(new ErrorResponseEntity(e.getErrorCode()));
    }

    // 3. 더 이상 사용하지 않는 ObjectMapper 관련 private 메소드는 삭제합니다.
}
