package com.example.onboarding_web_app.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dto.AssetPageData;
import com.example.onboarding_web_app.modal.Asset;
// import com.example.onboarding_web_app.modal.Asset;
import com.example.onboarding_web_app.service.AssetService;




@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        AssetPageData pageData = yourCsvReadingService.readAssetDataFromCsv(); // or however you load it
        model.addAttribute("name", pageData.getName());
        model.addAttribute("location", pageData.getLocation());
        model.addAttribute("assets", pageData.getAssets());
        return "home";
    }
}