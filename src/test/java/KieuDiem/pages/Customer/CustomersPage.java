package KieuDiem.pages.Customer;

import KieuDiem.keywords.WebUI;
import static KieuDiem.keywords.WebUI.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomersPage {
    //Cac thuoc tinh xac thuc object trong CustomersPage
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    //Object thuoc CustomersPage
    private By headerPageCustomers = By.xpath("(//div[@class = 'panel-body']//h4)[1]");
    private By buttonAddCustomer = By.xpath("//a[normalize-space() = 'New Customer']");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");
    private By textboxSearch = By.xpath("//div[@class = 'input-group']/input");
    private By tdCustomerName = By.xpath("//table[@id = 'DataTables_Table_0']//tbody/tr[1]/td[3]/a");

    //Ham xay dung
    private WebDriver driver;

    public CustomersPage(WebDriver _driver){
        driver = _driver;
        new WebUI(driver);
    }

    //Cac ham xu ly chuc nang thuoc CustomersPage
    public void verifyCustomerPage(){
        Assert.assertEquals(getCurrentURL(), PAGE_URL, "FAILED. URL is not valid");
        Assert.assertTrue(checkElementExist(headerPageCustomers), "FAILED. Header Page Customer is not exist" );
        Assert.assertEquals(getTextElement(headerPageCustomers), PAGE_TEXT, "FAILED. Header Page Customer is not valid" );
    }
    public AddCustomerPage clickNewCustomerButton(){
        clickElement(buttonAddCustomer);
        return new AddCustomerPage((driver));
    }
    public void searchCustomer (String companyName){
        waitForPageLoaded();
        setText(textboxSearch, companyName);
        sleep(2);
    }
    public CustomerDetailPage clickOnFirstRowCustomerName(){
        waitForPageLoaded();
        clickElement(tdCustomerName);

        return new CustomerDetailPage(driver);

    }
}
