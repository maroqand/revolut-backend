package com.nsarvar.exception;

/**
 * Created by nsarvar on 12/26/17.
 */

public class ResourceNotFoundException extends RuntimeException {
    private Long resourceId;

    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }
}
