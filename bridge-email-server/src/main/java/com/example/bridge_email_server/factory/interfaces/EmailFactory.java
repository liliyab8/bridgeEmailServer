package com.example.bridge_email_server.factory.interfaces;

import com.example.bridge_email_server.dto.impl.EmailMessageRequest;

public interface EmailFactory {
      void createAndRunEmailSender(EmailMessageRequest request);
      String getSupportedPostfix();
}
