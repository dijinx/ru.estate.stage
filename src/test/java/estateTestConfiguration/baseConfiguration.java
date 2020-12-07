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
    //данные для зарегистрированного пользователя
    public String userRegisteredMail = "02.12.test@mail.ru";
    public String userAuthorizationPassword = "1";
    public String registrationPage = "https://auth.dev.estate.mts.ru/auth/realms/mts-external/protocol/openid-connect/auth?client_id=estate-ext&redirect_uri=https%3A%2F%2Fstage.estate.mts.ru%2Fapi%2Fv1%2Fcallback&response_type=code&scope=username&state=b77d3d08-5340-4908-be14-21d6d6dd7519";
    //данные для регистрируемого пользователя
    public String userMailForRegistration = "02.12@test.test ";
    public String userPasswordForRegistration = "mavrodi";
    public String userWrongPasswordForRegistration = "1001001";
    public String userInn = "7707083893";
    public String userKpp = "773601001";
    public String userBik = "123456789";
    public String userOfficeNumber = "73";
    public String userName = "Сергей";
    public String userSurname = "Мавроди";
    public String userPatronymic = "Пантелеевич";
    public String userBirth = "27102004";
    public String userTelNumber = "0123456789";
    public String userAddress = "Московская область, г. Москва, ул. Ковальчука, д. 12, кв. 1";
    public String userCadastralNumber = "77:09:0003014:1042";
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

//    @AfterEach //после каждого теста
//    public void finish() {
//        driver.close();
//        driver.quit();
//    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    //Скриншот для шага
    //Allure.addAttachment("Press Registration Button", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
}

