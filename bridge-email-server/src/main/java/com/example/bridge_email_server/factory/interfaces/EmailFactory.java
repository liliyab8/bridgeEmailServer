package com.example.bridge_email_server.factory.interfaces;

import com.example.bridge_email_server.services.abstr.EmailSender;

public interface EmailFactory {
      EmailSender createEmailSender();
}
