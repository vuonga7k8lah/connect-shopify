package com.wiloke.corecommon.exceptions;

//import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@ControllerAdvice
@RestControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler(value = RequestExceptionHandler.class)
    public ResponseEntity<Object> handleApiRequestException(
            RequestExceptionHandler e
    ) {
        System.out.println("handleApiRequestException");
        GlobalException globalException = new GlobalException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                globalException,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(
            NotFoundException exception
    ) {
        System.out.println("handleNotFoundException");
        GlobalException globalException = new GlobalException(
                exception.getMessage(),
                exception,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                globalException,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UnauthorisedException.class)
    public ResponseEntity<Object> handleNotFoundException(
            UnauthorisedException exception
    ) {
        System.out.println("handleNotFoundException");
        GlobalException globalException = new GlobalException(
                exception.getMessage(),
                exception,
                HttpStatus.UNAUTHORIZED,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                globalException,
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        System.out.println("handleMethodArgumentNotValidException");
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder strBuilder = new StringBuilder();
        for (FieldError field : fieldErrors) {
            strBuilder.append(field.getField()).append(": ").append(field.getDefaultMessage()).append(System.getProperty("line.separator"));
        }

        GlobalException globalException = new GlobalException(
                strBuilder.toString(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                globalException,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ConstraintViolationException exception) {
        System.out.println("handleResourceNotFoundException");
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            strBuilder.append(violation.getMessage()).append(" ");
        }

        GlobalException globalException = new GlobalException(
                strBuilder.toString(),
                exception,
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                globalException,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler({FeignException.class, FeignException.InternalServerError.class})
//    public ResponseEntity<Object> handleFeignStatusException(FeignException exception) {
//        System.out.println("FeignException");
//        GlobalException globalException = new GlobalException(
//                exception.getMessage(),
//                exception,
//                HttpStatus.valueOf(exception.status()),
//                ZonedDateTime.now()
//        );
//
//        return new ResponseEntity<>(
//                globalException,
//                HttpStatus.valueOf(exception.status())
//        );
//    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleCommonException(SQLIntegrityConstraintViolationException exception) {
        System.out.println("SQLIntegrityConstraintViolationException");
        GlobalException globalException = new GlobalException(
                exception.getMessage(),
                exception,
                HttpStatus.valueOf(exception.getErrorCode()),
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(
                globalException,
                HttpStatus.valueOf(exception.getErrorCode())
        );
    }
}
