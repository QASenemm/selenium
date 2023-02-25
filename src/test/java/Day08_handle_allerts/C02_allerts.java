package Day08_handle_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_allerts {
    //  driver.get("https://the-internet.herokuapp.com/javascript_alerts")
    //bir method olusturun acceptsAllert
     // - 1.butonu tıklayın  uyarıdaki OK butonuna tıklayın ve result mesajının
     //" You successfully clicked an alert" oldugunu test edin
    //2-bir method olusturun dismisAlert
        //2.butona tıklayın uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfully" içermediğni test edin
//bir method olusturun sendkeysAlert
        //3. butona tıklayın uyarıdaki metin kutusuna isminizi yazın,ok butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın

static WebDriver driver;
@BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");

}
@AfterClass
    public static void  tearDown(){
    driver.quit();
}
//bir method olusturun acceptsAllert
//     // - 1.butonu tıklayın  uyarıdaki OK butonuna tıklayın ve result mesajının
//     //"You successfully clicked an alert" oldugunu test edin

    @Test
    public void acceptsAllert(){

        driver.findElement(By.xpath("//*[text()=\"Click for JS Alert\"]")).click();
        driver.switchTo().alert().accept();
        String exceptedResult="You successfully clicked an alert";
        WebElement yazi= driver.findElement(By.xpath("//p[@id=\"result\"]"));
        String actualResult= yazi.getText();
        Assert.assertEquals(exceptedResult,actualResult);
    }
    //2-bir method olusturun dismisAlert
    //2.butona tıklayın uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfully" içermediğni test edin
    @Test
    public void dismissAlert(){
    driver.findElement(By.xpath("//*[text()=\"Click for JS Confirm\"]")).click();
    driver.switchTo().alert().dismiss();
    String istenmeyenkelime="succesfully";
    WebElement sonucyazisi=driver.findElement(By.xpath("//p[@id=\"result\"]"));
    String actualyazi=sonucyazisi.getText();
    Assert.assertFalse(actualyazi.contains(istenmeyenkelime));
    }
    ///bir method olusturun sendkeysAlert
    //3. butona tıklayın uyarıdaki metin kutusuna isminizi yazın,ok butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
@Test
    public void sendKeysalert(){
    driver.findElement(By.xpath("//*[text()=\"Click for JS Prompt\"]")).click();
    driver.switchTo().alert().sendKeys("QA");
    driver.switchTo().alert().accept();
    WebElement sonuc= driver.findElement(By.xpath("//p[@id=\"result\"]"));
    String exceptedisim="QA";
    String actualisim=sonuc.getText();
    Assert.assertTrue(actualisim.contains(exceptedisim));

}

}
