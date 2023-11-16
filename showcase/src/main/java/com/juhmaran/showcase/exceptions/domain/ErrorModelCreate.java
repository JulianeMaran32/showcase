package com.juhmaran.showcase.exceptions.domain;

public class ErrorModelCreate {

    // 400 - BAD REQUEST
    public static ErrorModelCreate badRequest() {

        return ErrorModel.create()
                .status(ErrorEnum.BAD_REQUEST.getStatus())
                .code(ErrorEnum.BAD_REQUEST.getCode())
                .message(ErrorEnum.BAD_REQUEST.getMessage());
    }

    public static ErrorModelCreate emailAlreadyExistsException() {
        return ErrorModel.create()
                .status(ErrorEnum.EMAIL_ALREADY_EXISTS.getStatus())
                .code(ErrorEnum.EMAIL_ALREADY_EXISTS.getCode())
                .message(ErrorEnum.EMAIL_ALREADY_EXISTS.getMessage());
    }

    public static ErrorModelCreate documentNumberAlreadyExistsException() {
        return ErrorModel.create()
                .status(ErrorEnum.DOCUMENT_NUMBER_ALREADY_EXISTS.getStatus())
                .code(ErrorEnum.DOCUMENT_NUMBER_ALREADY_EXISTS.getCode())
                .message(ErrorEnum.DOCUMENT_NUMBER_ALREADY_EXISTS.getMessage());
    }

    public static ErrorModelCreate customerNotActiveException() {
        return ErrorModel.create()
                .status(ErrorEnum.CUSTOMER_NOT_ACTIVE.getStatus())
                .code(ErrorEnum.CUSTOMER_NOT_ACTIVE.getCode())
                .message(ErrorEnum.CUSTOMER_NOT_ACTIVE.getMessage());
    }


    // 401 - UNAUTHORIZED

    public static ErrorModelCreate unauthorized() {
        return ErrorModel.create()
                .status(ErrorEnum.UNAUTHORIZED.getStatus())
                .code(ErrorEnum.UNAUTHORIZED.getCode())
                .message(ErrorEnum.UNAUTHORIZED.getMessage());
    }

    // 403 - FORBIDDEN
    public static ErrorModelCreate forbidden() {
        return ErrorModel.create()
                .status(ErrorEnum.FORBIDDEN.getStatus())
                .code(ErrorEnum.FORBIDDEN.getCode())
                .message(ErrorEnum.FORBIDDEN.getMessage());
    }

    public static ErrorModelCreate customerNotLoggedInException() {
        return ErrorModel.create()
                .status(ErrorEnum.CUSTOMER_NOT_LOGGED_IN.getStatus())
                .code(ErrorEnum.CUSTOMER_NOT_LOGGED_IN.getCode())
                .message(ErrorEnum.CUSTOMER_NOT_LOGGED_IN.getMessage());
    }

    // 404 - NOT FOUND
    public static ErrorModelCreate notFound() {
        return ErrorModel.create()
                .status(ErrorEnum.NOT_FOUND.getStatus())
                .code(ErrorEnum.NOT_FOUND.getCode())
                .message(ErrorEnum.NOT_FOUND.getMessage());
    }

    public static ErrorModelCreate customerNotFoundException() {
        return ErrorModel.create()
                .status(ErrorEnum.CUSTOMER_NOT_FOUND.getStatus())
                .code(ErrorEnum.CUSTOMER_NOT_FOUND.getCode())
                .message(ErrorEnum.CUSTOMER_NOT_FOUND.getMessage());
    }

    public static ErrorModelCreate documentNumberNotChangeableException() {
        return ErrorModel.create()
                .status(ErrorEnum.DOCUMENT_NUMBER_NOT_CHANGEABLE.getStatus())
                .code(ErrorEnum.DOCUMENT_NUMBER_NOT_CHANGEABLE.getCode())
                .message(ErrorEnum.DOCUMENT_NUMBER_NOT_CHANGEABLE.getMessage());
    }

    public static ErrorModelCreate emailNotChangeableException() {
        return ErrorModel.create()
                .status(ErrorEnum.EMAIL_NOT_CHANGEABLE.getStatus())
                .code(ErrorEnum.EMAIL_NOT_CHANGEABLE.getCode())
                .message(ErrorEnum.EMAIL_NOT_CHANGEABLE.getMessage());
    }

    // 500 - INTERNAL SERVER ERROR
    public static ErrorModelCreate internalServerError() {
        return ErrorModel.create()
                .status(ErrorEnum.INTERNAL_SERVER_ERROR.getStatus())
                .code(ErrorEnum.INTERNAL_SERVER_ERROR.getCode())
                .message(ErrorEnum.INTERNAL_SERVER_ERROR.getMessage());
    }

}
