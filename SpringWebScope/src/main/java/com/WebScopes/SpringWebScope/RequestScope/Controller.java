package com.WebScopes.SpringWebScope.RequestScope;

import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    private SearchRequestData searchRequestData;

    public Controller(SearchRequestData searchRequestData) {
        this.searchRequestData = searchRequestData;
    }

    @GetMapping("/search")
    public String getData(@RequestParam String keyword,
                          @RequestParam int minPrice,
                          @RequestParam int maxPrice,
                          @RequestParam String category, Model model) throws InterruptedException {

        searchRequestData.setKeyword(keyword);
        searchRequestData.setMinPrice(minPrice);
        searchRequestData.setMaxPrice(maxPrice);
        searchRequestData.setCategory(category);


        System.out.println("Before sleep:");

        System.out.println("Keyword: " + searchRequestData.getKeyword());

        System.out.println("Object ID: " + System.identityHashCode(searchRequestData));

        Thread.sleep(5000);

        System.out.println("After sleep:");

        System.out.println("Keyword: " + searchRequestData.getKeyword());

        System.out.println("Object ID: " + System.identityHashCode(searchRequestData));

        model.addAttribute("data",searchRequestData);
        return "data";
    }
}
