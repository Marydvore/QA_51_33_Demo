package tests;

import dto.Student;
import enams.Gender;
import enams.Hobbies;
import enams.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test(groups = "smoke")
    public void practiceFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);
        Student student = new Student(
                "Ivan",
                "Ivanov",
                "ivanov123@gmail.com",
                Gender.OTHER,
                "0512345678",
                "10 May 1998",
                "Maths,Chemistry,English",
                hobbies,
                "",
                "daliya 2",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

        //Assert.assertTrue(practiceFormPage.validateMessageNegative());

        System.out.println("test failed");
        Assert.assertTrue(practiceFormPage.validateMessage());

    }

    @Test
    public void practiceFormPositiveTestWithSoftAssert() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.MUSIC);
        Student student = new Student(
                "Ivan",
                "Ivanov",
                "ivanov123@gmail.com",
                Gender.OTHER,
                "0512345678",
                "10 May 1998",
                "Maths,Chemistry,English",
                hobbies,
                "",
                "daliya 2",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

        //softAssert.assertTrue(practiceFormPage.validateMessageNegative(),"validateMessageNegative");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[2]")).getText()
                .contains(student.getLastName()), "validate lastName");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr[2]/td[2]")).getText()
                .contains(student.getEmail()), "validate email");

        System.out.println("test failed");
        softAssert.assertTrue(practiceFormPage.validateMessage(), "validateMessage");
        softAssert.assertAll();
    }
}
