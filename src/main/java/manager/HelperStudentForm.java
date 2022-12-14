package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperStudentForm extends HelperBase{
    public HelperStudentForm(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[text()='Practice Form']"));
    }

    public void fillStudentForm(Student student) {
    }
}
