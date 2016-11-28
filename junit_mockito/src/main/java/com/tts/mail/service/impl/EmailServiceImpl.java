package com.tts.mail.service.impl;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.constraints.NotNull;

import com.tts.mail.model.Email;
import com.tts.mail.service.EmailService;
import com.tts.mail.service.exception.CannotSendEmailException;
import com.tts.mail.service.impl.handler.EmailToMimeMessageHandler;
import com.tts.mail.service.impl.handler.TemplateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private EmailToMimeMessageHandler emailMessageHandler;

	@Autowired
	private JavaMailSender javaMailSender;

    @Autowired
    private TemplateHandler templateHandler;

	private final static String TEMPLATE_NAME = "send_process_log_email_template.ftl";

	@Override
	public boolean send() {
		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setFrom("Feed-File-Team@easternphoenix.com");
		mailMsg.setSubject("Feed-File Email Test");
		mailMsg.setTo("mike.leong@easternphoenix.com");
        mailMsg.setText("Dear Sir: \n This is a test message!" );
        mailSender.send(mailMsg);
        return true;
	}


	@Override
	public MimeMessage send(final @NonNull Email email) throws CannotSendEmailException {
		email.setSentAt(new Date());
		final MimeMessage mimeMsg = this.toMimeMessage(email);
		try {
			final MimeMultipart content = new MimeMultipart("processLog");

			// set the HTML text part
			final MimeBodyPart textPart = new MimeBodyPart();
			String body = "";
			textPart.setText(body, "UTF-8", "html");

			content.addBodyPart(textPart);
			mimeMsg.setContent(content);
			javaMailSender.send(mimeMsg);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new CannotSendEmailException("Error while sending the email due to problems with the mime content",
					e);

		}
		return mimeMsg;
	}

	private MimeMessage toMimeMessage(@NotNull Email email) {
		return emailMessageHandler.apply(email);
	}


}
