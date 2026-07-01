package com.WebScopes.SpringWebScope.RequestScope.FormValidationResult;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class FormProcessor {


    private boolean isValid;
    private String error;

    public Form process(Form form) throws InterruptedException {

        if(!form.getName().isBlank() && form.getEmail().contains("@") && form.getMessage().length()>=10){
            isValid=true;
            Thread.sleep(5000);
            error="No errors found";
            return form;

        }
        else {
            isValid=false;
            error="Errors exist in name/gmail/message length, check it again!!!";
            return form;
        }
    }


    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
