package com.sms.student_management.exception;

/**
 * Base exception for the student‑management module.
 * All custom exceptions and the global exception handler should use or extend this class.
 */
public class StudentException extends RuntimeException {
    // No‑args constructor
    public StudentException() {
        super();
    }

    // Constructor with a detail message
    public StudentException(String message) {
        super(message);
    }

    // Constructor with a cause
    public StudentException(Throwable cause) {
        super(cause);
    }

    // Constructor with both message and cause
    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    // Full constructor with suppression and writableStackTrace control
    protected StudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
