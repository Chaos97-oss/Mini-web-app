package com.example.onboarding_web_app.controller;

import com.example.dto.AssetDTO;
import com.example.dto.AssetPageData;
import com.example.onboarding_web_app.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        AssetPageData pageData = assetService.getAssetPageData(); 
        model.addAttribute("name", pageData.getName());
        model.addAttribute("location", pageData.getLocation());
        model.addAttribute("assets", pageData.getAssets());

        return "home"; 
    }

    @PostMapping("/assets")
    public String createAsset(@ModelAttribute("asset") AssetDTO assetDto) {
        assetService.saveAsset(assetDto);
        return "redirect:/";
    }

    @ModelAttribute("asset")
    public AssetDTO assetDTO() {
        return new AssetDTO();
    }

    @PostMapping("/addAsset")
    public String addAsset(@ModelAttribute("asset") AssetDTO assetDTO, Model model) {
        assetService.saveAsset(assetDTO);
        return "redirect:/assets"; 
    }
}