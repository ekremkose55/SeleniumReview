import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void hardAssert(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        //Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Electronics"));
    }

    @Test
    public void hardAssertEquals(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        //Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more

        String actualTitle = driver.getTitle();
        String expectedtitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

        Assert.assertEquals(actualTitle,expectedtitle);
    }

    @Test
    public void softAssert(){
        driver.get("https://www.amazon.com");
        WebElement allCatagory = driver.findElement(By.id("searchDropdownBox"));
        Select option1 = new Select(allCatagory);
        option1.selectByVisibleText("Books");

        WebElement searchButton = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchButton.sendKeys("JAVA");

        WebElement searchButton2 = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton2.submit();

        WebElement result = driver.findElement(By.xpath("//*[.='1-24 of over 20,000 results for']"));
        System.out.println(result.getText());//*[.='Java All-in-One For Dummies (For Dummies (Computer/Tech))']

        WebElement result1 = driver.findElement(By.xpath("//*[.='Java All-in-One For Dummies (For Dummies (Computer/Tech))']"));
        result1.click();

        WebElement backToResult = driver.findElement(By.id("breadcrumb-back-link"));
        Assert.assertTrue(backToResult.isDisplayed());

        System.out.println(backToResult.getText());

    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
}
