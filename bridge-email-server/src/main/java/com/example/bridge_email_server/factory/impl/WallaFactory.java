package com.example.bridge_email_server.factory.impl;

import com.example.bridge_email_server.factory.interfaces.EmailFactory;
import com.example.bridge_email_server.services.abstr.EmailSender;
import com.example.bridge_email_server.services.impl.WallaSender;

public class WallaFactory implements EmailFactory {
    @Override
    public EmailSender createEmailSender() {
        return new WallaSender();
    }
}
