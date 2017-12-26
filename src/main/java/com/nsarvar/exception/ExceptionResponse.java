package com.nsarvar.exception;

/**
 * Created by nsarvar on 12/26/17.
 */
public class ExceptionResponse {
    private int errorCode;
    private String errorMessage;
    private String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(int errorCode, String errorMessage, String details) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
