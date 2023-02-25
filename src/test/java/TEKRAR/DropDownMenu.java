package TEKRAR;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownMenu {
    /*
   amazona gidip
   dropdowndan books seceneini secip java aratalım
    ve arama sonuclarının java içerdigini test edin
    */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // dropdowndan books seceneini secip java aratalım
        WebElement ddm = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");
        WebElement aramakutusu = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        aramakutusu.sendKeys("Java" + Keys.ENTER);

        WebElement sonucyazisi = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        String sonucTitle = sonucyazisi.getText();
        String arananKelime = "Java";
        Assert.assertTrue(sonucTitle.contains(arananKelime));

    }
}
