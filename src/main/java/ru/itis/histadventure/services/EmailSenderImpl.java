package ru.itis.histadventure.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Component(value = "emailSenderImpl")
public class EmailSenderImpl implements EmailSender {

    private static String key = "key" + new Random().nextInt(100000);
    private static String sender = "azatyamanaev@yandex.ru";
    private static String receiver = "azatyamanaev@yandex.ru";
    public static String login;
    private static String notice;
    private static String link;
    @Value("${secret.key}")
    private String sKey;


    static {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.yandex.ru");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "8080");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }

    public void sendNotificationAboutRegistration(String login) {
        EmailSenderImpl.login = login;
        notice = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style type=\"text/css\">\n" +
                "        #message {\n" +
                "            font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        #message td, #message th {\n" +
                "            border: 1px solid #ddd;\n" +
                "            padding: 8px;\n" +
                "        }\n" +
                "\n" +
                "        #message tr:nth-child(even){background-color: #f2f2f2;}\n" +
                "\n" +
                "        #message tr:hover {background-color: #ddd;}\n" +
                "\n" +
                "        #message th {\n" +
                "            padding-top: 12px;\n" +
                "            padding-bottom: 12px;\n" +
                "            text-align: left;\n" +
                "            background-color: #4CAF50;\n" +
                "            color: white;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<table id=\"message\">\n" +
                "    <tr>\n" +
                "        <th>Dear User</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>To confirm registration you need to use this link:\n" +
                "            <a href=\"http://localhost:8080/confirming?key=" + sKey + "&login=" + login + "\">http://localhost:8080/confirming</a></td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        Properties properties = System.getProperties();
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("azatyamanaev", "Tuckjedtemyaux0");
            }
        });
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject("Registration on site");
            message.setContent(notice, "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void sendLinkToUploadedFile() {
        link = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style type=\"text/css\">\n" +
                "        #message {\n" +
                "            font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        #message td, #message th {\n" +
                "            border: 1px solid #ddd;\n" +
                "            padding: 8px;\n" +
                "        }\n" +
                "\n" +
                "        #message tr:nth-child(even){background-color: #f2f2f2;}\n" +
                "\n" +
                "        #message tr:hover {background-color: #ddd;}\n" +
                "\n" +
                "        #message th {\n" +
                "            padding-top: 12px;\n" +
                "            padding-bottom: 12px;\n" +
                "            text-align: left;\n" +
                "            background-color: #4CAF50;\n" +
                "            color: white;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<table id=\"message\">\n" +
                "    <tr>\n" +
                "        <th>Dear User</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>You can find your uploaded file through this link\n" +
                "            <a href=\"http://localhost:8080/files/file-name:\">http://localhost:8080/files</a></td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        Properties properties = System.getProperties();
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("azatyamanaev", "Tuckjedtemyaux0");
            }
        });
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(sender);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject("Uploaded file");
            message.setContent(link, "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getKey() {
        return key;
    }

    public static String getLogin() {
        return login;
    }
}
