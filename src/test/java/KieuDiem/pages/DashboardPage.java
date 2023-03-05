package KieuDiem.pages;

import KieuDiem.keywords.WebUI;
import static KieuDiem.keywords.WebUI.*;
import KieuDiem.pages.Customer.CustomersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    //Data trong nội bộ của trang Dashboard
    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";

    //Lưu các object
    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    By dashboarOption = By.xpath("//div[@class='screen-options-btn']");
    By checkboxQuickStatistics = By.xpath("//label[normalize-space()='Quick Statistics']");
    By widgetStatistics = By.xpath("//div[@id = 'widget-top_stats']");

    //Hàm xây dựng
    private WebDriver driver;
    public DashboardPage(WebDriver _driver){
        driver = _driver;
        new WebUI(driver);
    }

    //Hàm xử lý
    public void verifyDashboardPage(){
        //Kiểm tra URL của trang Dashboard
        Assert.assertEquals(getCurrentURL(), PAGE_URL, "FAILED. URL is not valid");
        //Kiểm tra object ở trang Dashboard
        Assert.assertTrue(checkElementExist(dashboarOption), "FAILED. Element is not exist");
        Assert.assertEquals(getTextElement(dashboarOption), PAGE_TEXT, "FAILED. Text is not valid");
    }
    public CustomersPage openCustomerPage(){
        WebUI.waitForPageLoaded();
        driver.findElement(menuCustomer).click();

        return new CustomersPage(driver);
    }
    public void clickCheckboxQuickStatistics(){
        clickElement(dashboarOption);
        clickElement(checkboxQuickStatistics);
    }
    public void verifyFilterStatistics(){
        //Kiểm tra widget này đang hiển thị (visible)
        Assert.assertTrue(verifyElementVisible(widgetStatistics , 5), "FAILED. Widget statistics is not visible at default");
        //Nhấn uncheck this widget
        clickCheckboxQuickStatistics();
        //Kiểm tra widget trên đã bị ẩn (not visible)
        Assert.assertTrue(verifyElementNOTVisible(widgetStatistics , 5), "FAILED. Widget statistics is visible at default");
    }
}
