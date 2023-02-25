package Day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Practice {
    public static void main(String[] args) {


    WebDriver driver;

    //@Before
   // public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    /* @After
     public void tearDown() {
         driver.close();
     }
     */

    //public void instagram(){
        driver.get("https://www.instagram.com");
        driver.findElement(By.name("username")).sendKeys("bir_test_engineer");
        driver.findElement(By.xpath(" //input[@name=\"password\"]")).sendKeys("*#2804Z.");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"_ac8f\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"_a9-- _a9_1\"]")).click();
        driver.findElement(By.xpath("(//div[@class=\"_aacl _aacp _aacu _aacx _aada\"])[1]")).click();

        driver.findElement(By.xpath("//input[@aria-label=\"Arama Girdisi\"]")).sendKeys("ogrenciveebeveynkocu.hulya");
        driver.findElement(By.xpath("(//div[@class=\"_abm4\"])[1]")).click();
        driver.findElement(By.xpath("(//div[@class=\"_aagu\"])[1]")).click();
        driver.findElement(By.xpath("//span[@class=\"_aamw\"]")).click();

    }
}



