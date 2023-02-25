package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropDownMenu {
    /*
    amazona gidip
    dropdowndan books seceneini secip java aratalım
     ve arama sonuclarının java içerdigini test edin
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        //dropdowndan books seceneini secip java aratalım
        //bunu yapmak için 3 adım var

        //1* dropdown ı locate edin
        WebElement dropDownmenusu= driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        //2** select objesi olusturup ,parametre olarak bir önceki adımda locate ettiğimiz ddm yı girelm

        Select select=new Select(dropDownmenusu);
        //3** dropdowndan var olan optıonlardan istedgimiz bir taneyi secelim

        select.selectByVisibleText("Books");
        //select.selectByIndex(5);
       // select.selectByValue("search-alias=stripbooks-intl-ship");

        //ve arama kutuusna java yazdıralım

        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucyazisi=driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
String sonucyazisiStr=sonucyazisi.getText();
String arananKelime="Java";
        Assert.assertTrue(sonucyazisiStr.contains(arananKelime));
        Thread.sleep(4000);
    }


}
