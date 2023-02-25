package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//'C:\Users\YOUR_USER_NAME\AppData\Local\Google\Chrome\User Data\Default\Extensions'    win
// /Users/YOUR_USER_NAME/Library/Application\ Support/Google/Chrome/Default/Extensions    mac
//gighmmpiobklfepjocnamgkkbiglidom

public class ApplicationManager {

    WebDriver wd;
    HelperStudentForm studentForm;
    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=C:\\tools\\5.3.2_0");//C:\tools\5.3.2_0
        wd =new ChromeDriver(options);


        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://demoqa.com");
        studentForm = new HelperStudentForm(wd);
       // Thread.sleep();
        returnToDemoQa();

    }

    private void returnToDemoQa() {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)).close();
       wd.switchTo().window(tabs.get(0));
    }

    public void stop(){
      // wd.quit();

    }

    public HelperStudentForm studentForm() {
        return studentForm;
    }
}
