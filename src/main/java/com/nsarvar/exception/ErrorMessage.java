package com.nsarvar.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Created by nsarvar on 12/26/17.
 *
 * @status property holds the operation call status. It will be anything from 4xx to signalize client errors or 5xx to mean server errors
 * @timestamp property holds the date-time instance of when the error happened.
 * @message property holds a user-friendly message about the error.
 * @debugMessage property holds a system message describing the error in more detail
 *
 */
public class ErrorMessage {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public ErrorMessage() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorMessage(HttpStatus status) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorMessage(HttpStatus status, Throwable ex) {
        this.status = status;
        this.debugMessage = ex.getLocalizedMessage();
        this.message = "Unexpected error";
    }

    public ErrorMessage(HttpStatus status, Throwable ex, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.debugMessage = ex.getLocalizedMessage();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
