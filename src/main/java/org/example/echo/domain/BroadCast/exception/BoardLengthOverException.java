package org.example.echo.domain.BroadCast.exception;

import org.example.echo.global.exception.CustomException;
import org.example.echo.global.exception.ErrorCode;

public class BoardLengthOverException extends CustomException {
    public BoardLengthOverException() {
        super(ErrorCode.BOARD_LENGTH_OVER);
    }
}
