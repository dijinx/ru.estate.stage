package estateSmokeSuit;

import estateTestConfiguration.baseConfiguration;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class userRegistration extends baseConfiguration {
    @Epic("TESTING FOR https://stage.estate.mts.ru/ tasks")
    @Feature(value = "Проверка успешной авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Пользователь успешно авторизуется")
    @Story(value = "История Проверка успешной авторизации")

    @Test
    //Проверка успешной авторизации c отображением шагов теста в аллюр
    public void Registration() throws InterruptedException {
        //зайти на сайт
        getUrl(SITE_URL);
        //нажать на кнопку регистрация
        pressButtonRegistrationMainPage();
        //получить ссылку страницы регистрации
        getURLRegistrationPage();
        //нажать на ссылку зарегистрироваться
        pressLinkRegistrationOnRegistrationPage();
        //ввести имя
        enterUserName(userName);
        //ввести фамилию
        enterUserSurname(userSurname);
        //ввести мейл
        enterUserEmail(userMail);
        //ввести пароль
        enterUserPassword(userPassword);
        //ввести подтверждение пароля
        enterUserPasswordConfirm(userPassword);
        //нажать кнопку зарегистрироваться
        pressButtonRegistration();
        // пауза сек
        Thread.sleep(3000);
        //проверка видимости элемента иконка профиля, статус виден
        authorizedUserUniqueElementIsDisplayed();
    }

    //образец шагов для теста, отображение в аллюр каждого шага и/или вводимых данных
    @Step(value = "Get URL")
    public void getUrl(String SITE_URL) {
        driver.get(SITE_URL);
        Allure.addAttachment("Press Registration Button", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step(value = "Press Registration Button main page")
    public void pressButtonRegistrationMainPage() {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[3]/div/button")).click();
        Allure.addAttachment("Press Registration Button", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step(value = "Get URL registration page")
    public void getURLRegistrationPage() {
        driver.get("https://auth.estate.mts.ru/auth/realms/mts-external/protocol/openid-connect/auth?client_id=estate-ext&redirect_uri=https%3A%2F%2Festate.mts.ru%2Fapi%2Fv1%2Fcallback&response_type=code&scope=username&state=abcf74b7-6e40-4d55-9a8e-997406c69670");
    }

    @Step(value = "Press link registration on registration page ")
    public void pressLinkRegistrationOnRegistrationPage() {
        driver.findElement(By.xpath("//*[@id=\"kc-registration\"]/span/a")).click();
    }

    @Step(value = "Enter user name")
    public void enterUserName(String userName) {
        driver.findElement(By.id("firstName")).sendKeys(userName);
    }

    @Step(value = "Enter user surname")
    public void enterUserSurname(String userSurname) {
        driver.findElement(By.id("lastName")).sendKeys(userSurname);
    }

    @Step(value = "Enter user email")
    private void enterUserEmail(String userMail) {
        driver.findElement(By.id("email")).sendKeys(userMail);
    }

    @Step(value = "Enter user password")
    public void enterUserPassword(String userPassword) {
        driver.findElement(By.id("password")).sendKeys(userPassword);
    }

    @Step(value = "Enter user password confirm")
    public void enterUserPasswordConfirm(String userPassword) {
        driver.findElement(By.id("password-confirm")).sendKeys(userPassword);
    }

    @Step(value = "Press button registration")
    public void pressButtonRegistration() {
        driver.findElement(By.xpath("//*[@id=\"kc-form-buttons\"]/input")).click();
    }

    @Step(value = "Authorized user unique element is displayed")
    public void authorizedUserUniqueElementIsDisplayed() {
        assertTrue(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div[3]/div/div[3]/span/div/img")).isDisplayed());
    }
    //образец шагов для теста, отображение в аллюр каждого шага и вводимых данных
}

