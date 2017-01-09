package ru.bobans.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Sender {

    private String username;
    private String password;
    private Properties props;

    public Sender()  {
        try {
            InputStream cfgFile = Sender.class.getResourceAsStream("/mail.properties");
            props = new Properties();
            props.load(new InputStreamReader(cfgFile, "UTF-8"));
            this.username=props.getProperty("username");
            this.password=props.getProperty("password");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void send(String subject, String text, String toEmail){
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);


            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}