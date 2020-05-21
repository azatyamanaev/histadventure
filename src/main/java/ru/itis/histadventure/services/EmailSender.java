package ru.itis.histadventure.services;

public interface EmailSender {
    void sendNotificationAboutRegistration(String login);
    void sendLinkToUploadedFile();
}
