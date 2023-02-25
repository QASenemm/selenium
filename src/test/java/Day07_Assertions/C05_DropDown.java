package Day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDown {
    /*
    https://the-internet.herokuapp.com/dropdown adresine gidin
    - index kullanarak secenek 1i secin ve yazdıırn
    - value kullanarak secenek 2 yi seçin ve yazdırın
    -visible text kullanarak secenek i seçin ve yazdırın
    - tüm dropdown optionları  yazdıırn
    - dropdownun boyutunu bulun,dropdown da öğe varsa  konsolda true,değilse false yazdırın
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
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //  - index kullanarak secenek 1i secin ve yazdıırn
        WebElement ddm = driver.findElement(By.xpath("//select[@id=\"dropdown\"]"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        // value kullanarak secenek 2 yi seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //-visible text kullanarak secenek 1 seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //- tüm dropdown optionları  yazdıırn
        List<WebElement> tumopsiyonlar = select.getOptions();
        for (WebElement each : tumopsiyonlar
        ) {
            System.out.println(each.getText());
            //- dropdownun boyutunu bulun,dropdown da öğe varsa  konsolda true,değilse false yazdırın
            int dropdownboyut = tumopsiyonlar.size();
            if (dropdownboyut == 4) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }


    }
}
