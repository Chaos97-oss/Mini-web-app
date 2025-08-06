package com.example.onboarding_web_app;

import com.example.onboarding_web_app.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnboardingWebAppApplication implements CommandLineRunner {

    @Autowired
    private AssetService assetService;

    public static void main(String[] args) {
        SpringApplication.run(OnboardingWebAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        assetService.loadAssetsFromCSV();
    }
}