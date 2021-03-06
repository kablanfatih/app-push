package com.kablanfatih.company;


import com.kablanfatih.company.config.JpaAuditingConfiguration;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CompanyApplication {

    public static void main(String[] args) {

        SpringApplication.run(CompanyApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new JpaAuditingConfiguration();
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
