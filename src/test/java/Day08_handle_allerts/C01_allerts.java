package Day08_handle_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_allerts {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown() {
        //driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[text()=\"Click for JS Alert\"]")).click();
        //alertte ok tusuna basın
        driver.switchTo().alert().accept();

        // result kısmında You successfully clicked on alert yazdgnı test edin
        String exceptedText = "You successfully clicked an alert";
        WebElement sonucyazielementi = driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String actualtext = sonucyazielementi.getText();

        Assert.assertEquals(exceptedText, actualtext);


    }
}
