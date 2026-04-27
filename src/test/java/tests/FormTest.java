
package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormTest extends BaseTest {

    @Test
    public void testFormInteractions() {

        // Step 1: Open Inputs page
        driver.get(ConfigReader.getBaseUrl() + "/inputs");

        FormPage formPage = new FormPage(driver);

        // Step 2: Input field
        formPage.enterInput("12345");

        // Simple validation
        Assert.assertTrue(driver.getCurrentUrl().contains("inputs"));

        // Step 3: Dropdown page
        driver.get(ConfigReader.getBaseUrl() + "/dropdown");
        formPage.selectDropdown();

        Assert.assertTrue(driver.getCurrentUrl().contains("dropdown"));

        // Step 4: Checkbox page
        driver.get(ConfigReader.getBaseUrl() + "/checkboxes");
        formPage.toggleCheckboxes();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkboxes"));

        // Step 5: Radio page
        driver.get(ConfigReader.getBaseUrl() + "/radio-buttons");
        formPage.selectRadio();

        Assert.assertTrue(driver.getCurrentUrl().contains("radio"));
    }
}