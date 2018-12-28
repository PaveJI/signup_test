package influential.signUp;

import influential.WebDriverSettings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class SignUp extends WebDriverSettings {

    @Test
    public void signUp(){

        driver.manage().window().maximize();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.openSignUpForm();
        signUpPage.filFisrtName("Pavel");
        signUpPage.filSecondName("Kipriyanov");

        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        String mail = "kipriyanov_pavel" + n + "@gmail.com";
        String username = "KipriyanovPavel" + n;

        signUpPage.filEmail(mail);
        signUpPage.nameCompany("FullHDTV");
        signUpPage.userName(username);
        signUpPage.userPassword("parol2314");
        signUpPage.passwordConfirm("parol2314");

        signUpPage.submitForm();
        signUpPage.chechSignUpSucces();

        System.out.println("Тест на регистрацию выполнен, браузер закрыт");
    }

    @Test
    public void signUpFailure(){

        driver.manage().window().maximize();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.openSignUpForm();
        signUpPage.submitForm();

        signUpPage.chechErrorRequiredFields();



        String nameFirstError = signUpPage.getErrorFirstName();
        Assert.assertEquals(nameFirstError, "PLEASE ADD A FIRST NAME");

        String nameLastError = signUpPage.getErrorSecondName();
        Assert.assertEquals(nameLastError, "PLEASE ADD A LAST NAME");

        String emailError = signUpPage.getErrorEmail();
        Assert.assertEquals(emailError, "PLEASE ADD AN EMAIL ADDRESS");

        String errorCompany = signUpPage.getErrorCompany();
        Assert.assertEquals(errorCompany, "PLEASE ADD A COMPANY NAME");

        String userNameError = signUpPage.getErrorUserName();
        Assert.assertEquals(userNameError, "PLEASE ADD A USERNAME");

        String passwordError = signUpPage.getErrorPassword();
        Assert.assertEquals(passwordError, "PLEASE ADD A PASSWORD");

        String confirmPasswordError = signUpPage.getErrorConfirmPassword();
        Assert.assertEquals(confirmPasswordError, "PLEASE CONFIRM YOUR PASSWORD");

        System.out.println("Тест завершился успешно и браузер закрыт");

    }


}
