package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    SoftAssert softAssert = new SoftAssert();

    @Test(groups = "smoke")
    public void practiceFormPositiveTest(){

        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);
        //hobbies.add(Hobbies.MUSIC);

        Student student = new Student("Nick", "Slavsky",
                "NickSlav@gmail.com", Gender.MALE, "7891235640",
                "15 Sep 2005", "Maths,Chemistry,English", hobbies, "",
                "Washington, DC", StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[0]);
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
        //Assert.assertTrue(practiceFormPage.validateMessageNegative());
        //System.out.println("failed test");
        Assert.assertTrue(practiceFormPage.validateMessage());
    }

    @Test(groups = "smoke")
    public void practiceFormPositiveTestWithSoftAssert(){

        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);
        //hobbies.add(Hobbies.MUSIC);

        Student student = new Student("Nick", "Slavsky",
                "NickSlav@gmail.com", Gender.MALE, "7891235640",
                "15 Sep 2005", "Maths,Chemistry,English", hobbies, "",
                "Washington, DC", StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[0]);
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
        //softAssert.assertTrue(practiceFormPage.validateMessageNegative(),"validateMessageNegative");
        //System.out.println("failed test");
        softAssert.assertTrue(practiceFormPage.validateMessage(), "validateMessagePositive");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[2]"))
                .getText().contains(student.getLastName()), "validateLastName");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr[2]/td[2]"))
                .getText().contains("NickSlav@"), "validateEmail");
        softAssert.assertAll();
    }

}
