package com.branko.midlevel.codejudge.exception;

import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
@AllArgsConstructor
public class RestExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse internalServerException(Exception ex) {
        log.error("Unexpected error", ex);
        return new CommonResponse("500", "Internal Server Error");
    }

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse badRequestException(Exception ex) {
        log.error("Unexpected error", ex);
        return new CommonResponse("400", ex.getMessage());
    }

    @ExceptionHandler({
            UsernameNotFoundException.class,
            BadCredentialsException.class
    })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CommonResponse unauthorizedException(Exception ex) {
        log.error("Unexpected error", ex);
        return new CommonResponse("401", "Invalid credentials");
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public CommonResponse forbiddenException(AccessDeniedException ex) {
        log.error("Unexpected error", ex);
        return new CommonResponse("403", "Access denied");
    }
}
