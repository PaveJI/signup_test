package influential.signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    @FindBy(css = "[href=\"/signup/talent#form-anchor\"]")
        private WebElement formAncor;
        private By formLocator = By.cssSelector("form");
        private By signUpComplete = By.id("signup-complete");
        private By errorMsgLocator = By.cssSelector("[class=\"error error-msg\"]");

    @FindBy(id = "name-first")
        private WebElement nameFirst;
    @FindBy(id = "name-last")
        private WebElement nameSecond;
    @FindBy(id = "email")
        private WebElement sendEmail;
    @FindBy(id = "company-name")
        private WebElement sendCompany;
    @FindBy(id = "username")
        private WebElement sendUserName;
    @FindBy(id = "password")
        private WebElement sendPassword;
    @FindBy(id = "password-confirm")
        private  WebElement sendConfirnPassword;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submit;

    public void openSignUpForm(){
        formAncor.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
    }
    public  void filFisrtName(String firstName){
        nameFirst.sendKeys(firstName);
    }
    public void filSecondName(String secondName){
        nameSecond.sendKeys(secondName);
    }

    public void filEmail(String email){
        sendEmail.sendKeys(email);
    }
    public void nameCompany (String company){
        sendCompany.sendKeys(company);
    }
    public void userName (String user){
        sendUserName.sendKeys(user);
    }

    public void userPassword (String password){
        sendPassword.sendKeys(password);
    }

    public void passwordConfirm (String confirmPassword){
        sendConfirnPassword.sendKeys(confirmPassword);
    }

    public void submitForm(){
        submit.click();
    }
    public void chechSignUpSucces(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpComplete));
    }
    //Error
    //         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"error error-msg\"]")));
    public void chechErrorRequiredFields(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));
    }
    public String getErrorFirstName(){
        WebElement nameFirstParent = nameFirst.findElement(By.xpath(".."));
        return nameFirstParent.findElement(By.cssSelector("p")).getText();
    }
    public String getErrorSecondName(){
        WebElement nameLastParent = nameSecond.findElement(By.xpath(".."));
        return nameLastParent.findElement(By.cssSelector("p")).getText();
    }
    public String getErrorEmail(){
        WebElement emailParent = sendEmail.findElement(By.xpath(".."));
        return emailParent.findElement(By.cssSelector("p")).getText();
    }
    public String getErrorCompany(){
        WebElement companyParent = sendCompany.findElement(By.xpath(".."));
        return companyParent.findElement(By.cssSelector("p")).getText();
    }
    public String getErrorUserName(){
        WebElement userNameParent = sendUserName.findElement(By.xpath(".."));
        return userNameParent.findElement(By.cssSelector("p")).getText();
    }
    public String getErrorPassword(){
        WebElement passwordParent = sendPassword.findElement(By.xpath(".."));
        return passwordParent.findElement(By.cssSelector("p")).getText();
    }
    public String getErrorConfirmPassword(){
        WebElement confirmPasswordParent = sendConfirnPassword.findElement(By.xpath(".."));
        return confirmPasswordParent.findElement(By.cssSelector("p")).getText();
    }
}

