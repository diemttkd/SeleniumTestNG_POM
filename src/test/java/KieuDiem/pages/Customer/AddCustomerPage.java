package KieuDiem.pages.Customer;

import KieuDiem.keywords.WebUI;
import static KieuDiem.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddCustomerPage extends CustomersPage {

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT = "Customer Details";

    public By tabCustomerDetails = By.xpath("(//div[@class = 'col-md-12']//li/a)[1]");
    public By textboxCompany = By.id("company");
    public By textboxVAT = By.id("vat");
    public By textboxPhone = By.id("phonenumber");
    public By textboxWebSite = By.id("website");
    public By dropdownGroups = By.xpath("//label[@for ='groups_in[]']/following-sibling::div");
    public By inputGroups = By.xpath("//label[@for ='groups_in[]']/following-sibling::div//input");
    public By dropdownCurrency = By.xpath("//label[@for ='default_currency']/following-sibling::div");
    public By inputCurrency = By.xpath("//label[@for ='default_currency']/following-sibling::div//input");
    public By dropdownDefaultLanguage = By.xpath("//label[@for ='default_language']/following-sibling::div");
    public By textareaAdress = By.xpath("//textarea[@id = 'address']");
    public By textboxCity = By.id("city");
    public By textboxState = By.id("state");
    public By textboxZipCode = By.id("zip");
    public By dropdownCountry = By.xpath("//label[@for =  'country']/following-sibling::div");
    public By searchCountry = By.xpath("//label[@for = 'country']/following-sibling::div//input");
    public By buttonSave = By.xpath("(//div[@class = 'panel_s']//button[normalize-space() = 'Save'])[2]");

    private WebDriver driver;

    public AddCustomerPage(WebDriver _driver) {
        super(_driver); //Tuân theo cấu trúc xây dựng của cha (CustomerPage)
        driver = _driver;
        //Khởi tạo hàm xây dựng của con (AddCustomerPage)
        new WebUI(driver); //Khởi tạo class WebUI để truyền giá trị từ bên ngoài vào
    }
    public void selectGroup(String groupName) {
        clickElement(dropdownGroups);
        driver.findElement(inputGroups).sendKeys(groupName, Keys.ENTER);
        clickElement(dropdownGroups);
    }

    public void selectCurrency(String currencyName) {
        clickElement(dropdownCurrency);
        driver.findElement(inputCurrency).sendKeys(currencyName, Keys.ENTER);
        clickElement(dropdownCurrency);
    }

    public void addDataNewCustomer(String CUSTOMER_NAME){
        waitForPageLoaded();

        setText(textboxCompany, CUSTOMER_NAME);
        setText(textboxVAT, "10");
        setText(textboxPhone, "0823214854");
        setText(textboxWebSite,"https://anhtester.com");
        selectGroup("Diem's Group");
        selectCurrency("USD");
        setText(textboxCity, "Da Nang");
        setText(textboxState, "Da Nang");
        setText(textboxZipCode, "10062");
        clickElement(buttonSave);

        waitForPageLoaded();
    }

}


