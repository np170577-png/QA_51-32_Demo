package pages;

import dto.Student;
import enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "firstName")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement inputLastName;

    @FindBy(id = "userEmail")
    WebElement inputEmail;

    @FindBy(css = "input[placeholder = 'Mobile Number']")
    WebElement inputMobile;

    @FindBy(id = "id='currentAddress'")
    WebElement inputAddress;

    @FindBy(id = "dateOfBirthInput")
    WebElement inputDateOfBirth;

    public void typePracticeForm(Student student) {
        inputFirstName.sendKeys(student.getFirstName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputDateOfBirth.sendKeys(student.getDateOfBirth());
        inputMobile.sendKeys(student.getMobile());
        inputAddress.sendKeys(student.getAddress());

    }

    private void typeGender(Gender gender){
        WebElement btnGender = driver.findElement(By.id(gender.getLocator()));
        btnGender.click();
    }

}
