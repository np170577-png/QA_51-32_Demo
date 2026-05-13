package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.BasePage;
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
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.MUSIC);

        Student student = new Student("Nick", "Slavsky",
                "NickSlav@gmail.com", Gender.MALE, "7891235640",
                "15 Sep 2005", "Maths,Chemistry,English", hobbies, "",
                "Washington, DC", "NSR", "Dehli");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);

    }
}
