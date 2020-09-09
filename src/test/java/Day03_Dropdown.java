import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void dropDown(){
        driver.get("https://www.amazon.com");
        WebElement allCatagory = driver.findElement(By.id("searchDropdownBox"));
        Select option1 = new Select(allCatagory);
        List<WebElement> allSections = option1.getOptions();
        for (WebElement element: allSections) {
            System.out.println(element.getText());
        }
        option1.selectByVisibleText("Baby");

        WebElement searchButton = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchButton.sendKeys("baby car");

        WebElement searchButton2 = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton2.submit();

    }

    @Test
    public void isDisplayed(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement header = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean baslik = header.isDisplayed();
        System.out.println("Sayfa Basligi: "+header.getText());

    }
    @Test
    public void isSelected(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@label='blah']"));
        boolean checkbox = checkBox1.isSelected();
        if(checkbox!= true){
            checkBox1.click();
        }

        WebElement enable = driver.findElement(By.xpath("//*[@onclick='swapInput()']"));

    }

    @Test
    public void isEnable() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enable = driver.findElement(By.xpath("//*[@onclick='swapInput()']"));
        enable.click();

        Thread.sleep(3000);
        WebElement message = driver.findElement(By.id("message"));
        System.out.println(message.getText());

        WebElement searchBox2 = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox2.sendKeys("Ekrem Kose");


    }
}
