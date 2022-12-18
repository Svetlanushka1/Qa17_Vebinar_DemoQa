import models.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        app.studentForm().selectItemForms();
        app.studentForm().selectPracticeForm();
    }

    @Test
    public void studentFormTest(){
        Student student = Student.builder()
                .firstName("John")
                .lastName("Dow")
                .email("john@mail.com")
                .gender("Male")
                .phone("12121234567")
                .birthday("30 June 2000")
                .subject("Math,Chemistry")
                .hobbies("Sports,Music")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon").build();


        app.studentForm().fillStudentForm(student);

    }
}
