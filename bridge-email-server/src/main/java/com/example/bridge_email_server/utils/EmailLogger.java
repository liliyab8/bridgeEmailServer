package com.example.bridge_email_server.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class EmailLogger {
    private static final String LOG_FILE = "emails-log.csv";
    public static synchronized void log(String body) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String timestamp = ZonedDateTime.now(ZoneId.of("Z")).truncatedTo(ChronoUnit.SECONDS).toString();
            int bodySize = body.getBytes().length;
            writer.append(timestamp)
                    .append(";")
                    .append(String.valueOf(bodySize))
                    .append(",")
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
