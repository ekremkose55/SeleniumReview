import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {

   static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void xpath() throws InterruptedException {
        driver.get("http://a.testaddressbook.com/");
        WebElement signIn = driver.findElement(By.linkText("Sign in"));
        signIn.click();

        Thread.sleep(3000);

        List<WebElement> allWebElements = driver.findElements(By.tagName("a"));  // veya "body"
        for (WebElement element:allWebElements) {
            System.out.println(element.getText());
        }

        WebElement userName = driver.findElement(By.cssSelector(".form-control"));
        WebElement password = driver.findElement(By.cssSelector("#session_password"));
        WebElement signInbutton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        userName.sendKeys("testtechproed@gmail.com");
        password.sendKeys("Test1234!");
        signInbutton.click();

        List<WebElement> allElements = driver.findElements(By.tagName("body"));
        for (WebElement element:allElements) {          //(By.xpath("//*")); da yazilabilir
            System.out.println(element.getText());
        }

        //WebElement allElements = driver.findElement(By.tagName("body"));
        // System.out.println(allElements.getText()); //Baska bir yol !!!

    }

    // Ders notlarini eklemeyi unutma!!

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
}
