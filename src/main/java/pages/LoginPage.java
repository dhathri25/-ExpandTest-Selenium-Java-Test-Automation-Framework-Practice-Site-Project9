
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // ✅ Correct locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By message = By.id("flash");   // success + error both
    private By logoutButton = By.xpath("//a[@href='/logout']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public String getMessage() {
        return getText(message);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public void clickLogout() {
        click(logoutButton);
    }
    public void waitForLogoutVisible() {
        waitForElement(logoutButton);
    }
}