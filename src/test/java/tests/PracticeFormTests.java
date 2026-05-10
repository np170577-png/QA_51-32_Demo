package tests;

import dto.Student;
import enums.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {
    @Test
    public void practiceFormPositiveTest(){
        Student student = new Student("Nick", "Slavsky",
                "NickSlav@gmail.com", Gender.MALE, "7891235640",
                "15 Sep 2005", "Maths,Chemistry,English", "Sports", "",
                "Washington, DC", "NSR", "Dehli");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

    }
}
