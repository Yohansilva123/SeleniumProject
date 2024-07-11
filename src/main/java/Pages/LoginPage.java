package Pages;

import Base.BasePage;
import org.openqa.selenium.By;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPage {

    private static By userNameTextBox = By.id("user-name");
    private static By passwordTextBox = By.id("password");
    private static By loginBtn = By.id("login-button");
    private static By loginLogo = By.xpath("//div[text()='Swag Labs']");

    public static void login(String userName, String password){
        if (BasePage.isElementVisible(loginLogo)){
            BasePage.typeText(userNameTextBox, userName);
            BasePage.typeText(passwordTextBox, password);
            BasePage.click(loginBtn);
        }else Logger.getAnonymousLogger().log(Level.WARNING,"Login Page is Not loaded");
    }
}
