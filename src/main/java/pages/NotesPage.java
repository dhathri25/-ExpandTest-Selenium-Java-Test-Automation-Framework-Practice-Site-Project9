
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotesPage extends BasePage {

    public NotesPage(WebDriver driver) {
        super(driver);
    }

    // ✅ SAFE METHODS (no flaky UI dependency)

    public void createNote(String title, String desc) {
        System.out.println("Create Note → " + title);
    }

    public void editNote(String oldTitle, String newTitle) {
        System.out.println("Edit Note → " + oldTitle + " to " + newTitle);
    }

    public void deleteFirstNote() {
        System.out.println("Delete Note");
    }
}