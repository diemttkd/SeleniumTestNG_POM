package KieuDiem.pages;

import KieuDiem.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;
import java.util.List;

public class LoginFactoryPage {
    private String URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGETEXT = "Login";

    //Khai báo object - là đối tượng Webelement
    @FindBy (xpath = "//h1")
    private WebElement headerPage;

    @FindBy (xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//div[@class = 'form-group']//button")
    private WebElement loginButton;

    @FindBys(@FindBy (xpath = "//aside[@id='menu']/ul/li"))
    private List<WebElement> menu;

    //Khai báo hàm xây dựng
    private WebDriver driver;
    public LoginFactoryPage (WebDriver _driver){
        driver = _driver;
        //Gọi hàm initElement của class PageFactory để khởi tạo các webelement bên trên
        PageFactory.initElements(driver, this);
    }

    //Viết hàm xử lý
    public void loginSuccess(String email, String password){
        driver.get(URL);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        WebUI.sleep(3);
        for (int i = 0; i < menu.size(); i++){
            System.out.println(menu.get(i).getText());
        }
    }
}
