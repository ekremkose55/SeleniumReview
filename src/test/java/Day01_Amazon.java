import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_Amazon {
    WebDriver driver;
    @Test
    public void amazon() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.xpath("//input[@name = 'field-keywords']"));
        searchBox.sendKeys("baby stroller");
        WebElement goBox = driver.findElement(By.xpath("//input[@value ='Go']"));
        goBox.click();

        Thread.sleep(3000);
        WebElement option2 = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/91WWjWWixhL._AC_SX180_SY120_QL70_.jpg']"));
        option2.click();

        WebElement price = driver.findElement(By.id("priceblock_ourprice"));
        WebElement ortalama = driver.findElement(By.xpath("//span[@data-hook='rating-out-of-text']"));
        System.out.println("URUN FIYATI: " + price.getText());
        System.out.println("URUN ORTALAMA DERECE: "+ ortalama.getText());
    }

    @Test
    public void google(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement googleSearch = driver.findElement(By.name("q"));
        WebElement searchBox = driver.findElement(By.name("btnK"));
        googleSearch.sendKeys("Ekrem Kose");
        searchBox.submit();
        WebElement result = driver.findElement(By.id("result-stats"));
        System.out.println("SONUC SAYISI: " + result.getText());

    }

}
