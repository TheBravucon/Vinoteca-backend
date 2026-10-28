package com.bravi.vinoteca.config;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.EnvironmentPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class DotEnvEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String jwtSecret = environment.getProperty("JWT_SECRET");
        
        if (jwtSecret != null && !jwtSecret.isEmpty()) {
            return;
        }

        try {
            Dotenv dotenv = Dotenv.configure()
                    .filename(".env")
                    .directory(".")
                    .ignoreIfMissing()
                    .load();

            Map<String, Object> envVars = new HashMap<>();
            for (DotenvEntry entry : dotenv.entries()) {
                envVars.put(entry.getKey(), entry.getValue());
            }

            if (!envVars.isEmpty()) {
                environment.getPropertySources().addFirst(
                        new MapPropertySource("dotenv", envVars)
                );
            }
        } catch (Exception e) {
            // No .env file found, rely on system environment variables
        }
    }
}
