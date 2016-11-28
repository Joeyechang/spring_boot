package com.tts.mail.model.impl;



import com.tts.mail.model.Email;
import lombok.*;

import javax.mail.internet.InternetAddress;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmailImpl implements Email, Serializable {
	private static final long serialVersionUID = 6366801201306964362L;
	
	@NonNull
	private InternetAddress from;

	private InternetAddress replyTo;

	private Collection<InternetAddress> to;

	private Collection<InternetAddress> cc;

	private Collection<InternetAddress> bcc;
	
	private @NonNull String subject;

	private @NonNull String body;

	private Charset encoding = Charset.forName("UTF-8");
	private Locale locale;

	private Date sentAt;
}
