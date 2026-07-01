package com.WebScopes.SpringWebScope.GlobalVisitor;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class VisitCounter {
    private int count=0;

    public int count(){
        return count++;
    }

    public int getCount() {
        return count;
    }
}
