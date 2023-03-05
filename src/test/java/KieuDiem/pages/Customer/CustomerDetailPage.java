package KieuDiem.pages.Customer;

import KieuDiem.keywords.WebUI;
import static KieuDiem.keywords.WebUI.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerDetailPage extends AddCustomerPage {
    //Object in Customer Detail page
    //Không phải khai báo lại
    //Không bị duplicate
    //Tiết kiệm thời gian
    //Có thay đổi thì chỉ sửa ở một chỗ


    private WebDriver driver;
    public CustomerDetailPage(WebDriver _driver){
        super(_driver);
        driver =  _driver;
    }

    public void checkCustomerDetail(String customerName){
        //Kiểm tra thì phải dùng assert
        Assert.assertEquals(getAttributeElement(textboxCompany, "value"), customerName, "Company Name not match");
    }
}
