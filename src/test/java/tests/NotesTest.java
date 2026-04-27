
package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NotesPage;

public class NotesTest extends BaseTest {

    @Test
    public void testCreateNote() {

        driver.get(ConfigReader.getBaseUrl() + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("practice", "SuperSecretPassword!");

        // ✅ No hardcoding
        driver.get(ConfigReader.getBaseUrl() + "/notes");

        NotesPage notesPage = new NotesPage(driver);

        notesPage.createNote("Test Note", "Automation Note");

        Assert.assertTrue(driver.getCurrentUrl().contains("notes"));
    }

    @Test
    public void testEditNote() {

        driver.get(ConfigReader.getBaseUrl() + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("practice", "SuperSecretPassword!");

        driver.get(ConfigReader.getBaseUrl() + "/notes");

        NotesPage notesPage = new NotesPage(driver);

        notesPage.editNote("Test Note", "Updated Note");

        Assert.assertTrue(driver.getCurrentUrl().contains("notes"));
    }

    @Test
    public void testDeleteNote() {

        driver.get(ConfigReader.getBaseUrl() + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("practice", "SuperSecretPassword!");

        driver.get(ConfigReader.getBaseUrl() + "/notes");

        NotesPage notesPage = new NotesPage(driver);

        notesPage.deleteFirstNote();

        Assert.assertTrue(driver.getCurrentUrl().contains("notes"));
    }
}