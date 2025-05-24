package com.filipedevgenz.mssecurity.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@Getter
public class RsaKeyProperties {
    @Value("classpath:keys/private.pem")
    private Resource privateKey;


    @Value("classpath:keys/public.pem")
    private Resource publicKey;
}
