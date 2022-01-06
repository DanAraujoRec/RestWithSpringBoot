package br.com.dansa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private String timestamp;
    private String message;
    private String details;
}
