package com.filipedevgenz.mssecurity.config;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenUtils {

    public static Instant getTokenDuration() {
        return LocalDateTime
                .now()
                .plusHours(1)
                .toInstant(ZoneOffset.of("-3"));
    }
}
