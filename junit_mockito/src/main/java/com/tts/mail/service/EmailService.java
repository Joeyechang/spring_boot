package com.tts.mail.service;

import com.tts.mail.model.Email;
import com.tts.mail.service.exception.CannotSendEmailException;

import javax.mail.internet.MimeMessage;


public interface EmailService {
	boolean send();

	MimeMessage send(Email mimeEmail) throws CannotSendEmailException;


}
