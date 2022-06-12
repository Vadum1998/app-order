import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    private WebDriver driver;


    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/win/chromedriver.exe");
    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearsDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void ShouldSendForm() {//открыть драйвер
        driver.get("http://localhost:9999");
        //System.out.println("");
        //по type
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Дубровин Вадим");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79012345678");
        // List<WebElement> textFields = driver.findElements(By.className("input__control"));
        // textFields.get(0).sendKeys("Дубровин Вадим");
        // textFields.get(1).sendKeys("+79012345678");
        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();
        // driver.findElement(By.className("checkbox__box")).click();//Галочка
        // driver.findElement(By.tagName("button")).click();// Продоложить
        String actualText = driver.findElement(By.cssSelector(".paragraph_theme_alfa-on-white")).getText().trim();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);


    }

    @Test
    void ShouldSendForm2() {//открыть драйвер
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Дубровин-Вадим");//Ф.И.
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+79012345678");//Телефон

        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();

        String actualText = driver.findElement(By.cssSelector(".paragraph_theme_alfa-on-white")).getText().trim();

        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actualText);
    }

}






