package tests;

import dto.Student;
import enams.Gender;
import enams.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    @Test
    public void practiceFormPositiveTest(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);
        Student student = new Student(
                "Ivan",
                "Ivanov",
                " iv@iv.com",
                Gender.OTHER,
                "0512345678",
                "10 May 1998",
                "Maths,Chemistry,English",
                hobbies,
                "",
                "daliya 2",
                "NSR",
                "Delhi");

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
    }
}
