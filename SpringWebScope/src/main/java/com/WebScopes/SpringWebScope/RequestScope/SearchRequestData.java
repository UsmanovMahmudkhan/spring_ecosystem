package com.WebScopes.SpringWebScope.RequestScope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class SearchRequestData {

    private String  keyword;
    private int minPrice;
    private int maxPrice;
    private String category;

    public SearchRequestData() {
    }

    public SearchRequestData(String keyword, int minPrice, int maxPrice, String catagory) {
        this.keyword = keyword;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.category = catagory;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catagory) {
        this.category = catagory;
    }

    @Override
    public String toString() {
        return "SearchRequestData{" +
                "keyword='" + keyword + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", category='" + category + '\'' +
                '}';
    }

}
