package experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class First {
    WebDriver driver = new ChromeDriver();

    @Test

    public void firstTest(){
        driver.get("https://demoqa.com/");
        pause(5000);
        driver.manage().window().maximize();
        pause(2000);
        driver.get("https://demoqa.com/elements");
        pause(5000);
        driver.navigate().back();
        pause(4000);
        driver.navigate().forward();
        pause(4000);
        driver.navigate().refresh();
        pause(2000);
        //driver.close();
        driver.quit();
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
