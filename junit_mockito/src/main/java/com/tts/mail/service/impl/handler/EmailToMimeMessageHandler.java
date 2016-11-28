package com.tts.mail.service.impl.handler;

import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

import java.util.function.Function;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.tts.mail.model.Email;
import com.tts.mail.service.exception.EmailConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


import lombok.NonNull;

@Component
public class EmailToMimeMessageHandler implements Function<Email, MimeMessage> {

	final static Logger logger = LoggerFactory.getLogger(EmailToMimeMessageHandler.class);

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailToMimeMessageHandler(final @NonNull JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public MimeMessage apply(final Email email) {
		final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		final MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

		try {
			messageHelper.setFrom(email.getFrom());
			if (ofNullable(email.getReplyTo()).isPresent()) {
				messageHelper.setReplyTo(email.getReplyTo());
			}
			if (ofNullable(email.getTo()).isPresent()) {
				for (final InternetAddress address : email.getTo()) {
					messageHelper.addTo(address);
				}
			}
			if (ofNullable(email.getCc()).isPresent()) {
				for (final InternetAddress address : email.getCc()) {
					messageHelper.addCc(address);
				}
			}
			if (ofNullable(email.getBcc()).isPresent()) {
				for (final InternetAddress address : email.getBcc()) {
					messageHelper.addBcc(address);
				}
			}
			messageHelper.setSubject(ofNullable(email.getSubject()).orElse(""));
			messageHelper.setText(ofNullable(email.getBody()).orElse(""));

			if (nonNull(email.getSentAt())) {
				messageHelper.setSentDate(email.getSentAt());
			}
		} catch (MessagingException e) {
			logger.error("Error while converting Email to MimeMessage");
			throw new EmailConversionException(e);
		}

		return mimeMessage;
	}

}