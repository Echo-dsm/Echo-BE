package org.example.echo.global.persistent;

import lombok.Data;
import org.example.echo.global.exception.ErrorCode;
import org.springframework.stereotype.Component;

@Data
public class ErrorResponseEntity {
    private ErrorCode errorCode;
    private String message;

//    public static ResponseEntity<ErrorResponseEntity> toResponseEntity(ErrorCode e) {
//        return ;
//    }

    public ErrorResponseEntity(ErrorCode e) {
        this.errorCode = e;
        this.message = e.getMessage();
    }
}
