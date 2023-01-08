package manager;

import models.Student;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        type(By.id("firstName"),student.getFirstName());
        type(By.id("lastName"),student.getLastName());
        type(By.id("userEmail"),student.getEmail());
        selectGender(student.getGender());
        type(By.id("userNumber"),student.getPhone());
        //typeBDay(student.getBirthday());
        selectBDay(student.getBirthday());
        addSubjects(student.getSubject());
        selectHobby(student.getHobbies());
        type(By.id("currentAddress"),student.getAddress());
        typeState(student.getState());
        typeCity(student.getCity());


    }

    private void typeCity(String city) {
        //type(By.id("react-select-4-input"),city);
        wd.findElement(By.id("react-select-4-input")).sendKeys(city);
        wd.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    private void typeState(String state) {
        Dimension dimension = wd.manage().window().getSize();
        System.out.printf("Height --->" + dimension.getHeight());


        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,400);");

       // type(By.id("react-select-3-input"),state);
        wd.findElement(By.id("react-select-3-input")).sendKeys(state);
        wd.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }

    private void selectHobby(String hobbies) {
        // label[for='hobbies-checkbox-1']
        String []all = hobbies.split(";");
        for (String s:all){
            switch (s){
                case "Sports":
                    click(By.cssSelector("label[for='hobbies-checkbox-1']"));
                    break;
                case "Reading":
                    click(By.cssSelector("label[for='hobbies-checkbox-2']"));
                    break;
                case "Music":
                    click(By.cssSelector("label[for='hobbies-checkbox-3']"));
                    break;
            }
        }
    }

    private void addSubjects(String subject) {

        if(subject!=null) {

            String []all = subject.split(";");

            click(By.id("subjectsInput"));

            for (String sub : all) {
                WebElement el = wd.findElement(By.id("subjectsInput"));
                el.sendKeys(sub);
                el.sendKeys(Keys.ENTER);
                pause(1000);

            }
        }

    }

    private void selectBDay(String birthday) { // 30 June 2000  === > ["30"] ["June"] ["2000"]
        WebElement dbirth = wd.findElement(By.id("dateOfBirthInput"));
        dbirth.click();

        String [] data =birthday.split(" ");

        new Select(wd.findElement(By.cssSelector("select.react-datepicker__month-select"))).selectByVisibleText(data[1]);
        new Select(wd.findElement(By.cssSelector("select.react-datepicker__year-select"))).selectByValue(data[2]);

        //String locator = "//div[text()='30']";
       // String locator = "//div[text()='"+"30"+"']";
        String locator = "//div[text()='"+data[0]+"']";

        String locator2 =String.format("//div[text()='%s']",data[0]);

        List<WebElement > list = wd.findElements(By.xpath(locator2));
        if(list.size()>1 && Integer.parseInt(data[0])>14){
            list.get(1).click();
        }else {
            list.get(0).click();
        }


        //click(By.xpath(locator));
    }


    private void typeBDay(String birthday) {
        WebElement dbirth = wd.findElement(By.id("dateOfBirthInput"));
        dbirth.click();

       String nameOS =  System.getProperty("os.name");   // "Mac "
        System.out.printf(nameOS);
        if(nameOS.startsWith("Mac")){
            dbirth.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }else {
            dbirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }
        dbirth.sendKeys(birthday);
        dbirth.sendKeys(Keys.ENTER);

    }

    private void selectGender(String gender) {
        if (gender.equals("Male")){
            click(By.cssSelector("label[for='gender-radio-1']"));
        }else if (gender.equals("Female")){
            click(By.cssSelector("label[for='gender-radio-2']"));
        }else if (gender.equals("Other")){
            click(By.cssSelector("label[for='gender-radio-3']"));
        }
    }

    public void uploadPhoto(String link) {
        wd.findElement(By.id("uploadPicture")).sendKeys(link);

    }

    public void submitForm() {
        click(By.id("submit"));
    }

    public void hideFooter() {
        JavascriptExecutor js =(JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void close() {
        click(By.id("closeLargeModal"));
    }
}
