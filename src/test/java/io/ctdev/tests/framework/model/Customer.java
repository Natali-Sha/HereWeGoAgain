package io.ctdev.tests.framework.model;

import sun.security.provider.certpath.Builder;

import java.util.Locale;

import static com.beust.jcommander.JCommander.newBuilder;

public class Customer {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void satEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void satPassword(String password) {
        this.password = password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Customer(){
    }

    private Customer(final Builder builder){
        email = builder.email;
        password = builder.password;

    }

    public static final class Builder{
        private String email;
        private String password;

        private Builder(){
        }

         public Builder withName (final String val){
            email = val;
            return this;
        }

        public Builder withPassword (final String val){
            email = val;
            return this;
        }

        public Customer build (){
            return new Customer(this);
        }

    }

}
