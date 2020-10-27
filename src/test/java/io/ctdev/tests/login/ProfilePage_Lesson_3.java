package io.ctdev.tests.login;

public class ProfilePage_Lesson_3 {
    private String nameCSS = "[name='name']";
    private String nameXpath = "//input[@name='name']";

    private String nicknameCSS = "[name='login']";
    private String nicknameXpath = "//input[@name='login']";

    private String phoneCSS = "[name='phoneNumber']";
    private String phoneXpath = "//input[@name='phoneNumber']";

    private String positionCSS = "[name='position']";
    private String positionXpath = "//input[@name='position']";

    private String departmentCSS = "[name='department']";
    private String departmentXpath = "//input[@name='department']";

    private String cancelCSS = "[class*='editUserProfile_buttonsBox'] :nth-of-type(1)";
    private String cancelXpath = "(.//*[contains(@class, 'button_btn')])[1]";

    private String saveCSS = "[class*='editUserProfile_buttonsBox'] :nth-of-type(2)";
    private String saveXpath = "(.//*[contains(@class, 'button_btn')])[2]";
}


