package com.tts.mail.model;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.mail.internet.InternetAddress;

public interface Email{

    InternetAddress getFrom();

    InternetAddress getReplyTo();

    Collection<InternetAddress> getTo();

    Collection<InternetAddress> getCc();

    Collection<InternetAddress> getBcc();

    default String getSubject() {
        return "";
    }

    default String getBody() {
        return "";
    }


    Charset getEncoding();

    Locale getLocale();

    Date getSentAt();

    void setSentAt(Date sentAt);
}
