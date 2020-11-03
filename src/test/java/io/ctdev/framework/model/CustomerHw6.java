package io.ctdev.framework.model;


public class CustomerHw6 {

    private String email;
    private String password;
    private String invalidUserName;
    private String invalidPass;

    private String userName;
    private String pass;
    private String answer;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInvalidPass() {
        return invalidPass;
    }

    public void setInvalidPas(String invalidPass) {
        this.invalidPass = invalidPass;
    }

    public String getInvalidUserName() {
        return invalidUserName;
    }

    public void setInvalidUserName(String invalidUserName) {
        this.invalidUserName = invalidUserName;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public static Builder newBuilder() {
        return new Builder();
    }

    public CustomerHw6() {
    }

    private CustomerHw6(final Builder builder) {
        email = builder.email;
        password = builder.password;
        invalidUserName = builder.invalidUserName;
        invalidPass = builder.invalidPass;


        pass = builder.pass;
        answer = builder.answer;
    }

    public static final class Builder {
        private String email;
        private String password;
        private String invalidUserName;
        private String invalidPass;


        private String pass;
        private String answer;

        private Builder() {
        }

        public Builder withName(final String val) {
            email = val;
            return this;
        }

        public Builder withPassword(final String val) {
            password = val;
            return this;
        }

        public Builder withInvalidUsername(final String val) {
            invalidUserName = val;
            return this;
        }

        public Builder withInvalidPass(final String val) {
            invalidPass = val;
            return this;
        }


        public Builder withPass(final String val) {
            pass = val;
            return this;
        }

        public Builder withAnswer(final String val) {
            answer = val;
            return this;
        }

        public CustomerHw6 build() {
            return new CustomerHw6(this);
        }
    }

}