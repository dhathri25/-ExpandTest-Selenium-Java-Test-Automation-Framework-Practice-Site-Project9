
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage {

    private By inputField = By.tagName("input");

    private By dropdown = By.id("dropdown");

    private By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private By checkbox2 = By.xpath("(//input[@type='checkbox'])[2]");

    private By radio1 = By.xpath("(//input[@type='radio'])[1]");
    private By radio2 = By.xpath("(//input[@type='radio'])[2]");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    // Input
    public void enterInput(String text) {
        type(inputField, text);
    }

    // Dropdown
    public void selectDropdown() {
        click(dropdown);
        click(By.xpath("//option[text()='Option 1']"));
    }

    // Checkbox
    public void toggleCheckboxes() {
        click(checkbox1);
        click(checkbox2);
    }

    // Radio
    public void selectRadio() {
        click(radio1);
    }
}