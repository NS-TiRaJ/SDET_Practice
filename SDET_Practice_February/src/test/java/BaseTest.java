import config.BaseConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

/**
 * Класс с настройками драйвера
 */
public class BaseTest {

    protected WebDriver driver;

    private final BaseConfiguration config = ConfigFactory.create(BaseConfiguration.class, System.getenv());

    /**
     * Общие настройки для Chrome драйвера
     */
    @BeforeMethod
    public void setUpChromeDriver(){
        System.setProperty(config.driverProperty(),config.driverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.url());

    }

    /**
     * Закрытие драйвера
     */
    @AfterMethod
    public void closeDriver(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.close();
    }
}
