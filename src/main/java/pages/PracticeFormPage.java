package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @FindBy(css = "textarea[placeholder='Current Address']")
    WebElement textAreaAddress;

    @FindBy(id = "dateOfBirthInput")
    WebElement inputDateOfBirth;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement inputSubjects;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement inputState;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    WebElement inputCity;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement message;

    public void typePracticeForm(Student student) {
        inputFirstName.sendKeys(student.getFirstName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputMobile.sendKeys(student.getMobile());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        textAreaAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
        //scrollToElement(btnSubmit);
        scrollActions();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();
    }

    public boolean validateMessage() {
        return isTextElementValid(message, "Thanks for submitting the form");
    }

    public boolean validateMessageNegative() {
        return isTextElementValid(message, "Wrong");
    }

    private void typeStateCity(String state, String city) {
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }

    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case MUSIC:
                    driver.findElement(By.id(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.id(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.id(h.getLocator())).click();
                    break;
            }
        }

    }

    private void typeSubjects(String subjects) {
        inputSubjects.click();
        String[] strArr = subjects.trim().split(","); // [,]{1}\\s+
        for (String s : strArr) {
            inputSubjects.sendKeys(s);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.id(gender.getLocator()));
        btnGender.click();
    }

    private void typeDateOfBirth(String dateOfBirth) {
        inputDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win")) {
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        if (operationSystem.startsWith("Mac")) {
            inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));

        }

        inputDateOfBirth.sendKeys(dateOfBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);

    }

//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)", element);
//    }
    public void scrollActions(){
        Actions actions = new Actions(driver);

        for (int i = 0; i < 10; i++) {
            actions.scrollByAmount(0, 700).perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

