package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPath {

    WebDriver driver = new ChromeDriver();

    @Test
    public void textBoxSelectors(){

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        hideFooter();
        pause(5000);

        WebElement inputFullName = driver.findElement(By.xpath ("//input[@placeholder='Full Name']"));
        inputFullName.sendKeys("Monkey");

        WebElement inputEmail= driver.findElement(By.xpath("//form/div[2]/div[2]/input"));
        inputEmail.sendKeys("monkey@gmail.com");

        WebElement inputCurrentAddress = driver.findElement(By.xpath("//label[text()='Current Address']/../..//textarea"));
        inputCurrentAddress.sendKeys("asddfglk;alfkdg");

        WebElement inputPermanentAddress = driver.findElement(By.xpath("//*[@id='permanentAddress-wrapper']//textarea"));
        inputPermanentAddress.sendKeys("Chunkey");

        WebElement btnSubmit=driver.findElement(By.xpath("//button[text()='Submit']"));
        btnSubmit.click();

        WebElement output=driver.findElement(By.xpath("//*[@id='output']"));
        System.out.println(output.getText());

    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

}
