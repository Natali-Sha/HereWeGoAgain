package io.ctdev.framework.model;


public class Customer_hw6 {

    private String email;
    private String password;
    private String invalidUserName;
    private String invalidPass;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) { this.password = password; }

    public String getInvalidPass() {
        return invalidPass;
    }
    public void setInvalidPas(String invalidPass) { this.invalidPass = invalidPass; }

    public String getInvalidUserName() { return invalidUserName; }
    public void setInvalidUserName(String invalidUserName) { this.invalidUserName = invalidUserName; }


    public static Builder newBuilder() {
        return new Builder();
    }

    public Customer_hw6() {
    }

    private Customer_hw6(final Builder builder) {
        email = builder.email;
        password = builder.password;
        invalidUserName = builder.invalidUserName;
        invalidPass = builder.invalidPass;
    }

    public static final class Builder {
        private String email;
        private String password;
        private String invalidUserName;
        private String invalidPass;

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

        public Customer_hw6 build() {
            return new Customer_hw6(this);
        }
    }

}