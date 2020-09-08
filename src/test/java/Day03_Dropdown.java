import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {

    WebDriver driver;

    @Test
    public void dropDown(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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

    }
}
