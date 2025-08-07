package com.example.onboarding_web_app.controller;

import com.example.dto.AssetPageData;
import com.example.onboarding_web_app.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private AssetService assetService;

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        AssetPageData pageData = assetService.getAssetPageData(); // ✅ FIXED LINE

        model.addAttribute("name", pageData.getName());
        model.addAttribute("location", pageData.getLocation());
        model.addAttribute("assets", pageData.getAssets());

        return "home"; // looks for home.html in src/main/resources/templates
    }
}