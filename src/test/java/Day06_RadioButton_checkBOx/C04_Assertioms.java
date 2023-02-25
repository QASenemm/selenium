package Day06_RadioButton_checkBOx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertioms {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teamDown() {
          driver.close();
    }

        @Test
        public void test01(){
            driver.get("https://www.amazon.com");

            //url nin https://www.facebook.com oldugunu test edin
/*
            if (driver.getCurrentUrl().equals("https://www.facebook.com ")){
                System.out.println("url testİ PASSED");
            }else {
                System.out.println("url testİ FAILED");
                 */


            String expectedurl="https://www.facebook.com";
            String actualUrl=driver.getCurrentUrl();
            Assert.assertEquals(" url beklenenden farklı:" ,expectedurl,actualUrl);
            }
        }




