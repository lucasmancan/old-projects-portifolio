package br.com.lucasmancan.medtech.api.domain.exceptions;

public class ReportException extends InternalException {

    public ReportException() {
    }

    public ReportException(String message) {
        super(message);
    }
}
