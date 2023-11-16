package com.juhmaran.showcase.exceptions.handler;

import com.juhmaran.showcase.exceptions.domain.ErrorModelCreate;
import com.juhmaran.showcase.exceptions.runtime.*;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
@NoArgsConstructor
public class ShowcaseExceptionHandler extends ResponseEntityExceptionHandler {

    // 400 - BAD REQUEST
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.badRequest(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    protected ResponseEntity<Object> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.emailAlreadyExistsException(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DocumentNumberAlreadyExistsException.class)
    protected ResponseEntity<Object> handleDocumentNumberAlreadyExistsException(DocumentNumberAlreadyExistsException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.documentNumberAlreadyExistsException(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotActiveException.class)
    protected ResponseEntity<Object> handleCustomerNotActiveException(CustomerNotActiveException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.customerNotActiveException(), HttpStatus.BAD_REQUEST);
    }

    // 401 - UNAUTHORIZED
    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.unauthorized(), HttpStatus.UNAUTHORIZED);
    }

    // 403 - FORBIDDEN
    @ExceptionHandler(ForbiddenException.class)
    protected ResponseEntity<Object> handleForbiddenException(ForbiddenException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.forbidden(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(CustomerNotLoggedInException.class)
    protected ResponseEntity<Object> handleCustomerNotLoggedInException(CustomerNotLoggedInException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.customerNotLoggedInException(), HttpStatus.FORBIDDEN);
    }

    // 404 - NOT FOUND
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.notFound(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    protected ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.customerNotFoundException(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DocumentNumberNotChangeableException.class)
    protected ResponseEntity<Object> handleDocumentNumberNotChangeableException(DocumentNumberNotChangeableException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.documentNumberNotChangeableException(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailNotChangeableException.class)
    protected ResponseEntity<Object> handleEmailNotChangeableException(EmailNotChangeableException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.emailNotChangeableException(), HttpStatus.NOT_FOUND);
    }

    // 500 - INTERNAL SERVER ERROR
    @ExceptionHandler(InternalServerErrorException.class)
    protected ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ErrorModelCreate.internalServerError(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
