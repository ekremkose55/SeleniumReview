import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
