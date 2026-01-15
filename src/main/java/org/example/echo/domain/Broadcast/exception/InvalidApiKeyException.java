package org.example.echo.domain.Broadcast.exception;

import org.example.echo.global.exception.CustomException;
import org.example.echo.global.exception.ErrorCode;

public class InvalidApiKeyException extends CustomException {
    public InvalidApiKeyException() {
        super(ErrorCode.INVALID_API_KEY);
    }
}
