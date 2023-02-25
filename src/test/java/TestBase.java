import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Random;

public class TestBase {

    static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
       // ApplicationManager app = new ApplicationManager();

        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
