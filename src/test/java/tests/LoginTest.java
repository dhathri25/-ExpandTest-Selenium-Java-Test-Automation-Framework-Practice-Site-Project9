
package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"practice", "SuperSecretPassword!", "success"},
                {"wrong", "wrongpass", "failure"},
                {"", "", "failure"}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedResult) {

        // ✅ Navigate to login page
        driver.get(ConfigReader.getBaseUrl() + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        String message = loginPage.getMessage();

        if (expectedResult.equals("success")) {
            Assert.assertTrue(message.contains("You logged into a secure area"),
                    "Login should be successful");
        } else {
            Assert.assertTrue(message.length() > 0,
                    "Error message should be displayed");
        }
    }
    @Test
    public void testLogout() {

        driver.get(ConfigReader.getBaseUrl() + "/login");

        LoginPage loginPage = new LoginPage(driver);

        // Login
        loginPage.login("practice", "SuperSecretPassword!");

        // ✅ Proper wait instead of Thread.sleep
        loginPage.waitForLogoutVisible();

        // Logout
        loginPage.clickLogout();

        // Verify
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "User should be redirected to login page after logout");
    }
}