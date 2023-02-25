package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropdownOptions {
    /*
    Amazon anasayfaya gidip
    dropdowna gidip booksu secelim
    sectiğimiz optıonu yazdıralım
    dropdowndaki opsiyonların toplam sayısının
    28 oldugunu test edelim
     */

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
       driver.quit();

    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        // bir ddm ile çalısıyorken son secilen optiona ulasmak isterseniz
        //select.getFirstSelectedOption() methodunu kullanmalısınız
        // bu method bize webelemnt döndurur uzerındeki yazıyı yazdırmak için getText() kullanılmalıdır
        System.out.println(select.getFirstSelectedOption().getText());
         List<WebElement> optionList=select.getOptions();
         int actualoptionsayisi=optionList.size();
         int expectedOptionsayisi=28;
        Assert.assertEquals(expectedOptionsayisi,actualoptionsayisi);

    }
}
