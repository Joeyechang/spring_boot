package com.tts.mail.service.exception;

public class EmailConversionException extends RuntimeException{
	
	private static final long serialVersionUID = -7828946649054724447L;

	public EmailConversionException(){
		super();
	}
	public EmailConversionException(final String message) {
        super(message);
    }

    public EmailConversionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EmailConversionException(final Throwable cause) {
        super(cause);
    }

}
