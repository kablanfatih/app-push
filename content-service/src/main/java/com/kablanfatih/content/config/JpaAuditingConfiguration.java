package com.kablanfatih.content.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class JpaAuditingConfiguration implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
