package org.example.echo.domain.Broadcast.exception;

import org.example.echo.global.exception.CustomException;
import org.example.echo.global.exception.ErrorCode;

public class EmptyMessageException extends CustomException {
    public EmptyMessageException() {
        super(ErrorCode.EMPTY_MESSAGE_REQUEST);
    }
}
