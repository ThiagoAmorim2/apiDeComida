package com.algaworks.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String message) {
        super(message);
    }
}
