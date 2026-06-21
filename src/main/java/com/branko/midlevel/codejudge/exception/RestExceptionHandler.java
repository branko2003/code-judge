package com.branko.midlevel.codejudge.exception;

import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
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
        return new CommonResponse("500", ex.getMessage());
    }

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse badRequestException(Exception ex) {
        return new CommonResponse("400", ex.getMessage());
    }
}
