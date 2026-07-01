package com.WebScopes.SpringWebScope.SettingsPage;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserPreferences {

    private String theme = "light";
    private String language = "en";

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void reset() {
        theme = "light";
        language = "en";
    }
}