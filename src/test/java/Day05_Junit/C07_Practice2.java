package Day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Practice2 {

        //https://www.saucedemo.com adresine gidin,
        @Test
    public void onlinealisveris() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://www.saucedemo.com");


       // username kutuusuna "standard_user" yazdırın
            driver.findElement(By.id("user-name")).sendKeys("standard_user");

       // password kısmına "secret_sauce" yazdırın
            driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("secret_sauce");
        //login kutusuna basın
            driver.findElement(By.id("login-button")).click();
        //ilk urunun ismini kaydedin ve bu urun sayfasına gidin
            driver.findElement(By.id("item_4_title_link")).click();
        //add to cart butonuna tıklayın
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //alısveriş sepetıne ekleyın
            driver.findElement(By.className("shopping_cart_link")).click();
        //sectiğiniz urunun basarılı olarak sepete eklendgini kontrol edin
            driver.findElement(By.xpath("//button[@class=\"btn btn_action btn_medium checkout_button\"]")).click();
        //sayfayı kapatın
            Thread.sleep(3000);
            driver.quit();

}
}
