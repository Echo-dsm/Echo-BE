package org.example.echo.domain.member.exception;

import org.example.echo.global.exception.CustomException;
import org.example.echo.global.exception.ErrorCode;

public class MemberNotFoundException extends CustomException {
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOTFOUND);
    }
}