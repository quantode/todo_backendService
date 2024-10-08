package com.shreeya.rest.webservices.restful_web_services.Model;




public class AuthenticationBean
{

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthenticationBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public AuthenticationBean(String message){
        this.message = message;
    }
}
