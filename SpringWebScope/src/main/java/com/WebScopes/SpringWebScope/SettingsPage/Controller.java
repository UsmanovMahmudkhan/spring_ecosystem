package com.WebScopes.SpringWebScope.SettingsPage;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    private final UserPreferences userPreferences;

    public Controller(UserPreferences userPreferences) {
        this.userPreferences = userPreferences;
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        model.addAttribute("preferences", userPreferences);
        return "settings";
    }

    @PostMapping("/settings")
    public String saveSettings(@RequestParam String theme,
                               @RequestParam String language) {
        userPreferences.setTheme(theme);
        userPreferences.setLanguage(language);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("preferences", userPreferences);
        return "home";
    }

    @PostMapping("/settings/reset")
    public String resetSettings() {
        userPreferences.reset();
        return "redirect:/settings";
    }
}