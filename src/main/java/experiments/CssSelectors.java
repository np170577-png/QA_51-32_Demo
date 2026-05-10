package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CssSelectors {

    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        pause(5000);
        WebElement footer = driver.findElement(By.tagName("footer"));
        System.out.println(footer.getTagName());
        hideFooter();
        //WebElement element = driver.findElement(By.cssSelector(".card-body"));
        WebElement element = driver.findElement(By.cssSelector(".card-body"));
        element.click();
        pause(4000);
        driver.navigate().back();
        //div[class='card-body']
        //*[class='card-body']
        WebElement element1 = driver.findElement(By.cssSelector("div[class='card-body']"));
        element1.click();
        pause(4000);
        driver.navigate().back();
        WebElement element2 = driver.findElement(By.className("card-body"));
        element2.click();
        pause(4000);
        WebElement textbox = driver.findElement(By.cssSelector("#item-0"));
        textbox.click();
        driver.navigate().back();
        WebElement textbox1 = driver.findElement(By.id("item-0"));
        textbox1.click();
        //li[id='item-0']
        // *[id='item-0']
        driver.navigate().back();
        driver.navigate().back();

        //WebElement bookstore = driver.findElement(By.cssSelector("div[class='category-cards'] a:last-child div[class='card mt-4 top-card']"));
        //bookstore.click();

        WebElement widget = driver.findElement(By.cssSelector("div[class='category-cards'] a:nth-child(4) div[class='card mt-4 top-card']"));
        widget.click();
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
