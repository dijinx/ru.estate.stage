package estateTestConfiguration;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseConfiguration {

    public String userMailForRegistration = "15TEST@gmail.com";
    public String userPasswordForRegistration = "mavrodi";
    public String userWrongPasswordForRegistration = "1001001";
    public String userInn = "7707083893";
    public String userKpp = "773601001";
    public String userBik = "123456789";
    public String officeNumber = "73";
    public String userName = "Сергей";
    public String userSurname = "Мавроди";
    public String userPatronymic = "Пантелеевич";
    public String userBirth = "27102004";
    public String userTelNumber = "0123456789";
    public String userAddress = "Московская область, г. Москва, ул. Ковальчука, д. 12, кв. 1";
    public String cadastralNumber = "77:09:0003014:1042";
    public String SITE_URL = "https://stage.estate.mts.ru/";
    public WebDriver driver;
    public ChromeOptions options;
    public boolean uiModeHeadless = false;

    @BeforeEach //перед каждым тестом
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/DVGORBU6/IdeaProjects/ru.estate.stage/chromedriver.exe"); //локальный файл хромдрайвера
//		WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.setHeadless(uiModeHeadless);// переключение режима интерфейса
        driver = new ChromeDriver(options);
    }

    @AfterEach //после каждого теста
    public void finish() {
        driver.close();
        driver.quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Скриншот для шага
    //Allure.addAttachment("Press Registration Button", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
}

