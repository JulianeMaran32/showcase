package com.juhmaran.showcase.exceptions.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel extends ErrorModelCreate implements Serializable {

    private Integer status;
    private String code;
    private String message;

    public ErrorModel status(Integer status) {
        this.status = status;
        return this;
    }

    public ErrorModel code(String code) {
        this.code = code;
        return this;
    }

    public ErrorModel message(String message) {
        this.message = message;
        return this;
    }

    public static ErrorModel create() {
        return new ErrorModel();
    }

}
