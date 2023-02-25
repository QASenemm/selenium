package Day06_RadioButton_checkBOx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBoxButton {
      WebDriver driver;
    @Before
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public  void teardown(){
        driver.quit();
    }

    @Test
            public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
       Thread.sleep(3000);
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        Thread.sleep(3000);
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        Thread.sleep(3000);
    }

}
