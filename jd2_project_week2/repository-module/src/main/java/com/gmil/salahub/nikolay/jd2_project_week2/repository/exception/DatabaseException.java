package com.gmil.salahub.nikolay.jd2_project_week2.repository.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String massage) {
        super(massage);
    }

    public DatabaseException(String massage, Throwable throwable) {
        super(massage, throwable);
    }
}
