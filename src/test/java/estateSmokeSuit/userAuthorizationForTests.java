package estateSmokeSuit;

import estateTestConfiguration.baseConfiguration;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class userAuthorizationForTests extends baseConfiguration {
    @Epic("TESTING FOR https://stage.estate.mts.ru/ tasks")
    @Feature(value = "Проверка успешной авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Пользователь успешно авторизуется")
    @Story(value = "История Проверка успешной авторизации")

    @Test
    public void authorization() {
        //зайти на сайт
        getUrl(SITE_URL);
        //нажать кнопку войти
        pressEnterButton();
        //получить страницу авторизации

        //ввести логин
        enterUserLogin(userRegisteredMail);
        //ввести пароль
        enterUserPassword(userAuthorizationPassword);
        //нажать кнопку войти
        presEnterButton2();
        //кликнуть по иконке
        findIconOnPage();
        //нажать выход в выпадающем меню
        pressExitInMenu();
        //нажать отмена в модалке
        pressCancelOnPush();
    }

    @Step(value = "Get URL")
    public void getUrl(String SITE_URL) {
        driver.get(SITE_URL);
    }

    @Step(value = "Press enter button")
    public void pressEnterButton() {
        driver.findElement(By.xpath("//*[@id=\"app-header\"]/div[1]/div/div[3]/div/button")).click();
    }

    @Step(value = "Get registration page")
    public void getRegistrationPage(String getRegistrationPage){
        driver.get("");
    }

    @Step(value = "Enter user login")
    public void enterUserLogin(String userRegisteredMail) {
        driver.findElement(By.id("username")).sendKeys(userRegisteredMail);
    }

    @Step(value = "Enter user password")
    public void enterUserPassword(String userAuthorizationPassword) {
        driver.findElement(By.xpath("password")).sendKeys(userAuthorizationPassword);
    }

    @Step(value = "Press enter button")
    public void presEnterButton2() {
        driver.findElement(By.xpath("kc-login"));
    }

    @Step(value = "Find icon on page")
    public void findIconOnPage() {
        driver.findElement(By.xpath("//*[@id=\"app-header\"]/div[1]/div/div[3]/div/div[3]")).click();
    }

    @Step(value = "Press exit in menu")
    public void pressExitInMenu() {
        driver.findElement(By.xpath("//*[@id=\"dropdown-menu-1956\"]/span/li")).click();
    }

    @Step(value = "Press cancel on push")
    public void pressCancelOnPush() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/div/button[1]")).click();
    }
}
