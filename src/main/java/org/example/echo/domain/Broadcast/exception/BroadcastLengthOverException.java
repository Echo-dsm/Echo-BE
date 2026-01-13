package org.example.echo.domain.Broadcast.exception;

import org.example.echo.global.exception.CustomException;
import org.example.echo.global.exception.ErrorCode;

public class BroadcastLengthOverException extends CustomException {
    public BroadcastLengthOverException() {
        super(ErrorCode.BOARD_LENGTH_OVER);
    }
}
