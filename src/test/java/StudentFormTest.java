import manager.DataProviderForStudent;
import models.Student;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class StudentFormTest extends TestBase{

    @BeforeClass
    public void preCondition(){
        app.studentForm().selectItemForms();
        app.studentForm().selectPracticeForm();
        app.studentForm().hideFooter();
    }

    @Test(dataProvider = "myDPMethod",dataProviderClass = DataProviderForStudent.class)
    public void studentFormTest(Student student){
        app.studentForm().fillStudentForm(student);
        app.studentForm().uploadPhoto("/Users/tayahatum/Qa17/Qa17_Vebinar_DemoQa/src/test/resources/boy.png");
        app.studentForm().submitForm();
        app.studentForm().close();

    }
    @Test(dataProvider = "myDPFile",dataProviderClass = DataProviderForStudent.class,groups = {"smoke"})
    public void studentFormTestFile(Student student){

        app.studentForm().fillStudentForm(student);
        app.studentForm().uploadPhoto("/Users/tayahatum/Qa17/Qa17_Vebinar_DemoQa/src/test/resources/boy.png");
        app.studentForm().submitForm();
        app.studentForm().close();

    }

    @Test
    public void studentFormTestFirst(){
        Student student = Student.builder()
                .firstName("John")
                .lastName("Dow")
                .email("john@mail.com")
                .gender("Male")
                .phone("12121234567")
                .birthday("30 June 2000")
                .subject("Math;Chemistry")
                .hobbies("Sports;Music")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon").build();


        app.studentForm().fillStudentForm(student);
        app.studentForm().uploadPhoto("/Users/tayahatum/Qa17/Qa17_Vebinar_DemoQa/src/test/resources/boy.png");
        app.studentForm().submitForm();

    }

}
