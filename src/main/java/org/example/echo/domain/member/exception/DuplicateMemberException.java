package org.example.echo.domain.member.exception;

import org.example.echo.global.exception.CustomException;
import org.example.echo.global.exception.ErrorCode;

public class DuplicateMemberException extends CustomException {
    public DuplicateMemberException() {
        super(ErrorCode.DUPLICATE_MEMBER, ErrorCode.DUPLICATE_MEMBER.getMessage());
    }
}