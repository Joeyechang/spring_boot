package com.tts.mail.service.exception;

public class CannotSendEmailException extends Exception {

	private static final long serialVersionUID = -5188164234341475878L;

	public CannotSendEmailException() {
    }

    public CannotSendEmailException(final String message) {
        super(message);
    }

    public CannotSendEmailException(final Throwable cause) {
        super(cause);
    }

    public CannotSendEmailException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CannotSendEmailException(final String message, final Throwable cause,
                                    final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}