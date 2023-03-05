package KieuDiem.pages;

import KieuDiem.keywords.WebUI;
import static KieuDiem.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Lưu object của trang Login
    //Dùng đối tượng By trong selenium để khai báo tên object cùng giá trị locator tương ứng
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//div[@class = 'form-group']//button");
    By rememberMeCheckbox = By.xpath("//div[@class='checkbox checkbox-inline']");
    By forgotPasswordLink = By.xpath("//div[@class = 'form-group']//a");
    By errormesssageEmail = By.xpath("//div[@class='text-center alert alert-danger']");

    //Hàm xây dựng để truyền vào driver
    private WebDriver driver;
    public LoginPage(WebDriver _driver){
        driver = _driver;
        new WebUI(driver);
    }

    //Viết các hàm xử lý cho trang Login
    public void verifyHeaderPage(){
        Assert.assertEquals(getTextElement(headerPage), PAGETEXT, "FAILED. Header Page text is not valid");
    }
    public void verifyerrormessageEmail(){
        Assert.assertTrue(driver.findElement(errormesssageEmail).isDisplayed(), "FAILED, error message is not displayed");
        Assert.assertEquals(getTextElement(errormesssageEmail), "Invalid email or password", "FAILED, error message text is not valid");
    }
    public void enterEmail(String email){
        setText(inputEmail, email);
    }
    public void enterPassword(String passwrod){
       setText(inputPassword, passwrod);
    }
    public void clickonLoginbutton(){
        clickElement(loginButton);
    }
    public DashboardPage loginCRM (String email, String password){
        openURL(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickonLoginbutton();

        return new DashboardPage(driver);
    }
    public void loginwithInvalidEmail (String email, String password){
        openURL(URL);
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickonLoginbutton();
        verifyerrormessageEmail();
        //Verify error message
    }
}
