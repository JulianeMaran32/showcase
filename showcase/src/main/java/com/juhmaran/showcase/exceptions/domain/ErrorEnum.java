package com.juhmaran.showcase.exceptions.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {

    BAD_REQUEST(400, "ARGUMENT NOT VALID", "Requisição inválida"),
    EMAIL_ALREADY_EXISTS(400, "EMAIL ALREADY EXISTS", "E-mail já está em uso."),
    DOCUMENT_NUMBER_ALREADY_EXISTS(400, "DOCUMENT NUMBER ALREADY EXISTS",
            "O documento já está em uso."),
    CUSTOMER_NOT_ACTIVE(400, "CUSTOMER NOT ACTIVE",
            "Cliente não ativo. Ativar conta ou realizar cadastro"),
    DOCUMENT_NUMBER_CANNOT_BE_NULL(400, "DOCUMENT NUMBER CANNOT BE NULL", "O documento não pode ser nulo."),

    UNAUTHORIZED(401, "UNAUTHORIZED", "Usuário não autenticado. Faça o login para acessar."),

    FORBIDDEN(403, "FORBIDDEN",
            "Página restrita. Usuário não possui permissão para acessar a página."),
    CUSTOMER_NOT_LOGGED_IN(403, "CUSTOMER NOT LOGGED IN",
            "Deve efetuar o login para realizar as alterações desejadas."),

    NOT_FOUND(404, "NOT FOUND", "Não foi possível encontrar os dados solicitados."),
    CUSTOMER_NOT_FOUND(404, "CUSTOMER NOT FOUND", "Cliente não encontrado!"),
    DOCUMENT_NUMBER_NOT_CHANGEABLE(404, "DOCUMENT NUMBER NOT CHANGEABLE",
            "Número de documento não pode ser alterado!"),
    EMAIL_NOT_CHANGEABLE(404, "EMAIL NOT CHANGEABLE", "E-mail não pode ser alterado!"),

    INTERNAL_SERVER_ERROR(500, "SERVER ERROR",
            "Ocorreu um erro interno no servidor. Tente mais tarde");

    private final Integer status;
    private final String code;
    private final String message;

}
